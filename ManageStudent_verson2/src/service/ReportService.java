/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.List;
import model.Report;
import model.ReportHandle;

/**
 *
 * @author Admin
 */
public class ReportService {

    private final ReportHandle reportHandle;

    public ReportService(ReportHandle reportHandle) {
        this.reportHandle = reportHandle;
    }
    
    public List<Report> getListReport() {
        return reportHandle.getAllReports();
    }
}
