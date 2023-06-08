package yu.artisttour.server.domain.report.service;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import yu.artisttour.server.domain.report.repository.ReportRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ReportService {

    private final ReportRepository reportRepository;

    public ResponseEntity reportList() {
        return ResponseEntity.ok(reportRepository.findAll());
    }

}
