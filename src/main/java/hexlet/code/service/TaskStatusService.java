package hexlet.code.service;

import hexlet.code.dto.taslstatus.TaskStatusCreateDTO;
import hexlet.code.dto.taslstatus.TaskStatusDTO;
import hexlet.code.dto.taslstatus.TaskStatusUpdateDTO;
import hexlet.code.exception.ResourceNotFoundException;
import hexlet.code.mapper.TaskStatusMapper;
import hexlet.code.repository.TaskStatusRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public final class TaskStatusService {

    private final TaskStatusRepository repository;
    private final TaskStatusMapper statusMapper;

    public List<TaskStatusDTO> getAll() {
        var statuses = repository.findAll();
        return statusMapper.map(statuses);
    }

    public TaskStatusDTO getById(Long id) {
        var status = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TaskStatus with id " + id + " not found"));
        return statusMapper.map(status);
    }

    public TaskStatusDTO create(TaskStatusCreateDTO statusData) {
        var status = statusMapper.map(statusData);
        repository.save(status);
        return statusMapper.map(status);
    }

    public TaskStatusDTO update(TaskStatusUpdateDTO statusData, Long id) {
        var status = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TaskStatus with id " + id + " not found"));
        statusMapper.update(statusData, status);
        repository.save(status);
        return statusMapper.map(status);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("TaskStatus with id" + id + "not found");
        }
        repository.deleteById(id);
    }
}
