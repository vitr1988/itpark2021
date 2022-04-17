package lesson42.shell;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import static lesson42.config.JobConfig.DB_MIGRATION_JOB;

@ShellComponent
@RequiredArgsConstructor
public class UserInteraction {

    private final Job dbMigrationJob;

    private final JobLauncher jobLauncher;
    private final JobExplorer jobExplorer;

    @ShellMethod(value = "startMigration", key = "sm")
    public void startMigration() throws Exception {
        JobExecution execution = jobLauncher.run(dbMigrationJob, new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters());
        System.out.println(execution);
    }

    @ShellMethod(value = "showInfo", key = "si")
    public void showInfo() {
        System.out.println(jobExplorer.getJobNames());
        System.out.println(jobExplorer.getLastJobInstance(DB_MIGRATION_JOB));
    }
}
