package com.group4.miniproject.dto;

import com.group4.miniproject.domain.Schedule;
import com.group4.miniproject.domain.ScheduleType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleRequestDto {
    private Long id;
    @NotNull(message = "날짜를 선택해 주세요.")
    private LocalDateTime startDate;

    @NotNull(message = "날짜를 선택해 주세요.")
    private LocalDateTime endDate;

    private ScheduleType scheduleType;

    private String content;

    public Schedule toEntity(PrincipalDto dto) {
        return Schedule.builder()
                .startDate(startDate)
                .endDate(endDate)
                .type(scheduleType)
                .content(content)
                .account(dto.toEntity())
                .build();

    }
}
