package yu.artisttour.server.domain.report.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import yu.artisttour.server.domain.report.service.ReportService;

@RestController
@RequestMapping("/report")
@AllArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/list")
    private ResponseEntity reportList(){
        return reportService.reportList();
    }


}
