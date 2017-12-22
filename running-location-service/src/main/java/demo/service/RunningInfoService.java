package demo.service;

import demo.domain.RunningInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RunningInfoService {
    List<RunningInfo> saveRunningInfo(List<RunningInfo> runningInfoList);
    void deleteAll();
    Page<RunningInfo> findAll(Pageable pageable);
    void deleteByRunningId(String runningId);
    Page<RunningInfo> findByRunningId(String runningId, Pageable pageable);
    Page<RunningInfo> findByUserName(String username, Pageable pageable);
}
