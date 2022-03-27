package lesson28.service.impl;

import lesson28.service.PrintService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("local")
public class PrintServiceImpl implements PrintService {
}
