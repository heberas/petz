package br.com.petz.service;

import org.springframework.stereotype.Service;

@Service
public class WorkFlowHealthCheckServiceImpl implements WorkFlowHealthCheckService {
    @Override
    public void liveness() {
        System.out.println("Liveness OK !");
    }

    @Override
    public void readiness() {
        System.out.println("Readiness OK !");
    }
}
