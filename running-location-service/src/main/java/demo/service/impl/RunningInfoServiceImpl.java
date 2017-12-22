package demo.service.impl;

import demo.domain.RunningInfo;
import demo.domain.RunningInfoRepository;
import demo.service.RunningInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.List;

@Service
public class RunningInfoServiceImpl implements RunningInfoService{

    private RunningInfoRepository runningInfoRepository;

    @Autowired
    public RunningInfoServiceImpl(RunningInfoRepository runningInfoRepository) {
        this.runningInfoRepository = runningInfoRepository;
    }

    @Override
    public List<RunningInfo> saveRunningInfo(List<RunningInfo> runningInfoList) {
        return this.runningInfoRepository.save(runningInfoList);
    }

    @Override
    public void deleteAll() {
        this.runningInfoRepository.deleteAll();
    }

    @Override
    public Page<RunningInfo> findAll(Pageable pageable) {
        return this.runningInfoRepository.findAll(pageable);
    }

    @Override
    public void deleteByRunningId(String runningId) {
        this.runningInfoRepository.delete(runningId);
    }

    @Override
    public Page<RunningInfo> findByRunningId(String runningId, Pageable pageable) {
        return this.runningInfoRepository.findByRunningId(runningId, pageable);
    }

    @Override
    public Page<RunningInfo> findByUserName(String username, Pageable pageable) {
        return this.runningInfoRepository.findByUserName(username, pageable);
    }
}
