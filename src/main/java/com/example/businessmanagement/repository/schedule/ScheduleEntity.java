package com.example.businessmanagement.repository.schedule;


import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleEntity {

  Long scheduleId;

  int userId;

  @JsonFormat(pattern = "yyyy-MM-dd")
  LocalDate workingDate;

  String place;

  String workContent;

  int numberOfPeople;

}
