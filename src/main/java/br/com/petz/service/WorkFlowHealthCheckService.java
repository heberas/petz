package br.com.petz.service;

public interface WorkFlowHealthCheckService {

    void liveness();

    void readiness();

}