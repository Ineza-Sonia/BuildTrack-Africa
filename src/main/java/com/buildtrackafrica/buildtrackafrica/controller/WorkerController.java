package com.buildtrackafrica.buildtrackafrica.controller;

import com.buildtrackafrica.buildtrackafrica.dao.WorkerDAO;
import com.buildtrackafrica.buildtrackafrica.entity.Worker;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.List;

@Named("workerController")
@RequestScoped
public class WorkerController {

    private Long editId;

    public Long getEditId() { return editId; }
    public void setEditId(Long editId) { this.editId = editId; }
    private Worker worker = new Worker();
    private final WorkerDAO workerDAO = new WorkerDAO();

    public String save() {
        workerDAO.save(worker);
        worker = new Worker();
        return "list.xhtml?faces-redirect=true";
    }

    public String update() {
        workerDAO.update(worker);
        return "list.xhtml?faces-redirect=true";
    }

    public String delete(Long id) {
        workerDAO.delete(id);
        return "list.xhtml?faces-redirect=true";
    }

    public void loadForEdit(Long id) {
        this.worker = workerDAO.findById(id);
    }

    public List<Worker> getAllWorkers() {
        return workerDAO.findAll();
    }

    public Worker getWorker() { return worker; }
    public void setWorker(Worker worker) { this.worker = worker; }
}