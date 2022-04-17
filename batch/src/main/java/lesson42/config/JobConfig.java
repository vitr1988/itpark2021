package lesson42.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.data.domain.Sort.Direction;
import lesson42.mapper.AuthorMapper;
import lesson42.mapper.BookMapper;
import lesson42.mapper.CommentMapper;
import lesson42.mapper.GenreMapper;
import lesson42.model.sql.Author;
import lesson42.repository.nosql.AuthorRepository;
import lesson42.repository.nosql.BookRepository;
import lesson42.repository.nosql.CommentRepository;
import lesson42.repository.nosql.GenreRepository;
import lesson42.repository.sql.AuthorJpaRepository;
import lesson42.repository.sql.BookJpaRepository;
import lesson42.repository.sql.CommentJpaRepository;
import lesson42.repository.sql.GenreJpaRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class JobConfig {

    private static final int CHUNK_SIZE = 1;
    public static final String DB_MIGRATION_JOB = "dbMigrationJob";

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    private final ItemReadListener<Author> itemReadListener = new ItemReadListener<>() {
        @Override
        public void beforeRead() {
            log.info("Начало чтения");
        }
        @Override
        public void afterRead(Author author) {
            log.info("Конец чтения");
        }
        @Override
        public void onReadError(Exception e) {
            log.info("Ошибка чтения");
        }
    };

    private final ItemWriteListener<lesson42.model.nosql.Author> itemWriteListener = new ItemWriteListener<>() {
        @Override
        public void beforeWrite(List<? extends lesson42.model.nosql.Author> list) {
            log.info("Начало записи");
        }
        @Override
        public void afterWrite(List<? extends lesson42.model.nosql.Author> list) {
            log.info("Конец записи");
        }
        @Override
        public void onWriteError(Exception e, List<? extends lesson42.model.nosql.Author> list) {
            log.info("Ошибка записи");
        }
    };

    private final ItemProcessListener<Author, lesson42.model.nosql.Author> itemProcessListener = new ItemProcessListener<>() {
        @Override
        public void beforeProcess(Author o) {
            log.info("Начало обработки");
        }
        @Override
        public void afterProcess(Author o, lesson42.model.nosql.Author o2) {
            log.info("Конец обработки");
        }
        @Override
        public void onProcessError(Author o, Exception e) {
            log.info("Ошбка обработки");
        }
    };

    private final ChunkListener chunkListener = new ChunkListener() {
        @Override
        public void beforeChunk(ChunkContext chunkContext) {
            log.info("Начало пачки");
        }
        @Override
        public void afterChunk(ChunkContext chunkContext) {
            log.info("Конец пачки");
        }
        @Override
        public void afterChunkError(ChunkContext chunkContext) {
            log.info("Ошибка пачки");
        }
    };

    private final JobExecutionListener jobExecutionListener = new JobExecutionListener() {
        @Override
        public void beforeJob(JobExecution jobExecution) {
            log.info("Начало job");
        }
        @Override
        public void afterJob(JobExecution jobExecution) {
            log.info("Конец job");
        }
    };

    @Bean
    public RepositoryItemReader<lesson42.model.sql.Author> authorReader(AuthorJpaRepository authorRepository) {
        val authorRepositoryItemReader = new RepositoryItemReader<lesson42.model.sql.Author>();
        authorRepositoryItemReader.setRepository(authorRepository);
        authorRepositoryItemReader.setMethodName("findAll");
        Map<String, Direction> sorts = new HashMap<>();
        sorts.put("id", Direction.ASC);
        authorRepositoryItemReader.setSort(sorts);
        return authorRepositoryItemReader;
    }

    @Bean
    public ItemProcessor<lesson42.model.sql.Author, lesson42.model.nosql.Author> authorProcessor(AuthorMapper authorMapper) {
        return authorMapper::toDocumentEntity;
    }

    @Bean
    public RepositoryItemWriter<lesson42.model.nosql.Author> authorWriter(lesson42.repository.nosql.AuthorRepository authorRepository) {
        RepositoryItemWriter<lesson42.model.nosql.Author> itemWriter = new RepositoryItemWriter<>();
        itemWriter.setRepository(authorRepository);
        itemWriter.setMethodName("save");
        return itemWriter;
    }

    @Bean
    public RepositoryItemReader<lesson42.model.sql.Genre> genreReader(GenreJpaRepository genreRepository) {
        val genreRepositoryItemReader = new RepositoryItemReader<lesson42.model.sql.Genre>();
        genreRepositoryItemReader.setRepository(genreRepository);
        genreRepositoryItemReader.setMethodName("findAll");
        Map<String, Direction> sorts = new HashMap<>();
        sorts.put("code", Direction.ASC);
        genreRepositoryItemReader.setSort(sorts);
        return genreRepositoryItemReader;
    }

    @Bean
    public ItemProcessor<lesson42.model.sql.Genre, lesson42.model.nosql.Genre> genreProcessor(GenreMapper genreMapper) {
        return genreMapper::toDocumentEntity;
    }

    @Bean
    public RepositoryItemWriter<lesson42.model.nosql.Genre> genreWriter(lesson42.repository.nosql.GenreRepository genreRepository) {
        RepositoryItemWriter<lesson42.model.nosql.Genre> itemWriter = new RepositoryItemWriter<>();
        itemWriter.setRepository(genreRepository);
        itemWriter.setMethodName("save");
        return itemWriter;
    }

    @Bean
    public RepositoryItemReader<lesson42.model.sql.Book> bookReader(BookJpaRepository bookRepository) {
        val bookRepositoryItemReader = new RepositoryItemReader<lesson42.model.sql.Book>();
        bookRepositoryItemReader.setRepository(bookRepository);
        bookRepositoryItemReader.setMethodName("findAll");
        Map<String, Direction> sorts = new HashMap<>();
        sorts.put("id", Direction.ASC);
        bookRepositoryItemReader.setSort(sorts);
        return bookRepositoryItemReader;
    }

    @Bean
    public ItemProcessor<lesson42.model.sql.Book, lesson42.model.nosql.Book> bookProcessor(BookMapper bookMapper) {
        return bookMapper::toDocumentEntity;
    }

    @Bean
    public RepositoryItemWriter<lesson42.model.nosql.Book> bookWriter(lesson42.repository.nosql.BookRepository bookRepository) {
        RepositoryItemWriter<lesson42.model.nosql.Book> itemWriter = new RepositoryItemWriter<>();
        itemWriter.setRepository(bookRepository);
        itemWriter.setMethodName("save");
        return itemWriter;
    }

    @Bean
    public RepositoryItemReader<lesson42.model.sql.Comment> commentReader(CommentJpaRepository commentRepository) {
        val commentRepositoryItemReader = new RepositoryItemReader<lesson42.model.sql.Comment>();
        commentRepositoryItemReader.setRepository(commentRepository);
        commentRepositoryItemReader.setMethodName("findAll");
        Map<String, Direction> sorts = new HashMap<>();
        sorts.put("id", Direction.ASC);
        commentRepositoryItemReader.setSort(sorts);
        return commentRepositoryItemReader;
    }

    @Bean
    public ItemProcessor<lesson42.model.sql.Comment, lesson42.model.nosql.Comment> commentProcessor(CommentMapper commentMapper) {
        return commentMapper::toDocumentEntity;
    }

    @Bean
    public RepositoryItemWriter<lesson42.model.nosql.Comment> commentWriter(lesson42.repository.nosql.CommentRepository commentRepository) {
        RepositoryItemWriter<lesson42.model.nosql.Comment> itemWriter = new RepositoryItemWriter<>();
        itemWriter.setRepository(commentRepository);
        itemWriter.setMethodName("save");
        return itemWriter;
    }

    @Bean
    public Step authorStep(RepositoryItemReader<lesson42.model.sql.Author> authorReader,
                           ItemProcessor<lesson42.model.sql.Author, lesson42.model.nosql.Author> authorProcessor,
                           RepositoryItemWriter<lesson42.model.nosql.Author> authorWriter) {
        return this.stepBuilderFactory.get("authorStep")
                .<lesson42.model.sql.Author, lesson42.model.nosql.Author>chunk(CHUNK_SIZE)
                .reader(authorReader)
                .processor(authorProcessor)
                .writer(authorWriter)
                .listener(itemReadListener)
                .listener(itemWriteListener)
                .listener(itemProcessListener)
                .listener(chunkListener)
                .taskExecutor(new SimpleAsyncTaskExecutor())
                .build();
    }

    @Bean
    public Step genreStep(RepositoryItemReader<lesson42.model.sql.Genre> genreReader,
                          ItemProcessor<lesson42.model.sql.Genre, lesson42.model.nosql.Genre> genreProcessor,
                          RepositoryItemWriter<lesson42.model.nosql.Genre> genreWriter) {
        return this.stepBuilderFactory.get("genreStep")
                .<lesson42.model.sql.Genre, lesson42.model.nosql.Genre>chunk(CHUNK_SIZE)
                .reader(genreReader)
                .processor(genreProcessor)
                .writer(genreWriter)
                .listener(itemReadListener)
                .listener(itemWriteListener)
                .listener(itemProcessListener)
                .listener(chunkListener)
                .taskExecutor(new SimpleAsyncTaskExecutor())
                .build();
    }

    @Bean
    public Step bookStep(RepositoryItemReader<lesson42.model.sql.Book> bookReader,
                            ItemProcessor<lesson42.model.sql.Book, lesson42.model.nosql.Book> bookProcessor,
                            RepositoryItemWriter<lesson42.model.nosql.Book> bookWriter) {

        return this.stepBuilderFactory.get("bookStep")
                .<lesson42.model.sql.Book, lesson42.model.nosql.Book>chunk(CHUNK_SIZE)
                .reader(bookReader)
                .processor(bookProcessor)
                .writer(bookWriter)
                .listener(itemReadListener)
                .listener(itemWriteListener)
                .listener(itemProcessListener)
                .listener(chunkListener)
                .taskExecutor(new SimpleAsyncTaskExecutor())
                .build();
    }

    @Bean
    public Step commentStep(RepositoryItemReader<lesson42.model.sql.Comment> commentReader,
                          ItemProcessor<lesson42.model.sql.Comment, lesson42.model.nosql.Comment> commentProcessor,
                          RepositoryItemWriter<lesson42.model.nosql.Comment> commentWriter) {
        return this.stepBuilderFactory.get("commentStep")
                .<lesson42.model.sql.Comment, lesson42.model.nosql.Comment>chunk(CHUNK_SIZE)
                .reader(commentReader)
                .processor(commentProcessor)
                .writer(commentWriter)
                .listener(itemReadListener)
                .listener(itemWriteListener)
                .listener(itemProcessListener)
                .listener(chunkListener)
                .taskExecutor(new SimpleAsyncTaskExecutor())
                .build();
    }

    @Bean
    public Step clearDbStep(Tasklet tasklet) {
        return this.stepBuilderFactory.get("clearDbStep")
                .tasklet(tasklet)
                .build();
    }

    @Bean
    public Tasklet tasklet(AuthorRepository authorRepository,
                           GenreRepository genreRepository,
                           CommentRepository commentRepository,
                           BookRepository bookRepository) {
        return (contribution, chunkContext) -> {
            authorRepository.deleteAll();
            genreRepository.deleteAll();
            bookRepository.deleteAll();
            commentRepository.deleteAll();
            return RepeatStatus.FINISHED;
        };
    }

    @Bean
    public Job dbMigrationJob(
            Step clearDbStep
            , Step authorStep
            , Step genreStep
            , Step bookStep
            , Step commentStep) {
        return jobBuilderFactory.get(DB_MIGRATION_JOB)
                .incrementer(new RunIdIncrementer())
                .start(clearDbStep)
                .next(authorStep)
                .next(genreStep)
                .next(bookStep)
                .next(commentStep)
                .listener(jobExecutionListener)
                .build();
    }
}
