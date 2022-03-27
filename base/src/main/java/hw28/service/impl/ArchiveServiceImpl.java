package hw28.service.impl;

import hw28.service.ArchiveService;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Service
public class ArchiveServiceImpl implements ArchiveService {

    private static final String ZIP = ".zip";

    @Override
    public Optional<String> zip(String source) {
        final File file = new File(source);
        final String newZipFileName = FilenameUtils.removeExtension(source) + ZIP;
        try (final ZipFile zipFile = new ZipFile(file.getParent() + File.separator + FilenameUtils.getName(newZipFileName))) {
            if (file.isFile()) {
                zipFile.addFile(source);
            } else {
                zipFile.addFolder(file);
            }
        } catch (IOException io) {
            System.out.printf("Возникли проблемы во время архивирования файла %s", source);
            return Optional.empty();
        }
        return Optional.of(newZipFileName);
    }

    @Override
    public Optional<String> unzip(String source, String password) {
        final ZipFile zipFile = new ZipFile(source);
        if (StringUtils.isNotBlank(password)) {
            zipFile.setPassword(password.toCharArray());
        }
        final String parent = new File(source).getParent();
        try {
            zipFile.extractAll(parent);
        } catch (ZipException zipException) {
            System.out.printf("Возникли проблемы во время разархивирования файла %s", source);
        }
        return Optional.of(parent);
    }
}
