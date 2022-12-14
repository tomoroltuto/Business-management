package com.example.businessmanagement.service.performance;

import com.example.businessmanagement.repository.performance.PerformanceEntity;
import com.example.businessmanagement.repository.performance.PerformanceRepository;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PerformanceServiceImpl implements PerformanceService {

  private final PerformanceRepository performanceRepository;

  @Override
  public PerformanceEntity findById(Long performanceId) {
    return performanceRepository.findById(performanceId)
        .orElseThrow(() -> new PerformanceEntityNotFoundException(performanceId));
  }

  @Override
  public List<PerformanceEntity> findPerformanceList() {
    return performanceRepository.findPerformanceList();
  }

  @Override
  public PerformanceEntity create(int userId, LocalDate workingDate, String place,
      String workContent, int numberOfPeople) {
    var entity = new PerformanceEntity(null, userId, workingDate, place,
        workContent, numberOfPeople);
    performanceRepository.create(entity);
    return entity;
  }

  @Override
  public void update(Long performanceId, int userId, LocalDate workingDate,
      String place, String workContent, int numberOfPeople) {
    performanceRepository.findById(performanceId)
        .orElseThrow(() -> new PerformanceEntityNotFoundException(performanceId));
    performanceRepository.update(new PerformanceEntity(performanceId, userId, workingDate, place,
        workContent, numberOfPeople));
  }

  @Override
  public void delete(Long performanceId) {
    performanceRepository.findById(performanceId)
        .orElseThrow(() -> new PerformanceEntityNotFoundException(performanceId));
    performanceRepository.delete(performanceId);
  }
}
