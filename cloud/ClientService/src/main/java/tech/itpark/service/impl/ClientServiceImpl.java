package tech.itpark.service.impl;

import tech.itpark.domain.Client;
import tech.itpark.dto.ClientDto;
import tech.itpark.mapper.ClientMapper;
import tech.itpark.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.itpark.service.ClientService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    @Transactional
    public Long createClient(String name) {
        val clientEntity = new Client(name);
        clientRepository.save(clientEntity);
        return clientEntity.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ClientDto> findAll() {
        //TODO: pagination support
        return clientMapper.toDtos(clientRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ClientDto> findById(Long id) {
        return clientMapper.toOptional(clientRepository.findById(id));
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void update(Long id, String name) {
        clientRepository.findById(id).ifPresent(clientEntity -> clientEntity.setName(name));
    }
}
