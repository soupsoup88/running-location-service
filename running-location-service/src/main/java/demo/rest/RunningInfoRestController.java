package demo.rest;

import demo.domain.RunningInfo;
import demo.service.RunningInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RunningInfoRestController {
    private RunningInfoService runningInfoService;

    @Autowired
    RunningInfoRestController(RunningInfoService runningInfoService) {
        this.runningInfoService = runningInfoService;
    }

    @RequestMapping(value = "running_info", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<RunningInfo> runningInfoList) {
        runningInfoService.saveRunningInfo(runningInfoList);
    }

    @RequestMapping(value = "running_info/{runningId}", method = RequestMethod.GET)
    public Page<RunningInfo> findByRunningId(@RequestParam("page") int page,
                                             @RequestParam("size") int size,
                                             @PathVariable("runningId") String runningId) {
        return this.runningInfoService.findByRunningId(runningId, new PageRequest(page, size));
    }

    @RequestMapping(value = "running_info/username/{username}", method = RequestMethod.GET)
    public Page<RunningInfo> findByUserName(@RequestParam("page") int page,
                                             @RequestParam("size") int size,
                                             @PathVariable("username") String username) {
        return this.runningInfoService.findByUserName(username, new PageRequest(page, size));
    }

    @RequestMapping(value = "running_info", method = RequestMethod.GET)
    public Page<RunningInfo> findDescByHealthWarningLevel (@RequestParam("page") int page,
                                                           @RequestParam("size") int size) {
        return this.runningInfoService.findAll(new PageRequest(
                page,
                size,
                Sort.Direction.DESC, "healthWarningLevel"));
    }

    @RequestMapping(value = "running_info/delete/{runningId}", method = RequestMethod.DELETE)
    public void deleteByRunningId(@PathVariable("runningId") String runningId) {
        this.runningInfoService.deleteByRunningId(runningId);
    }
}
