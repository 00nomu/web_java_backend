package web.backend.module.worker.repository;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WorkerWeeklyPayDataVo {
    public String 고정유무;
    public int 주급자동;
    public int 주휴포함주급;
    public int 주휴미포함주급;
    public int 고정주급;

}
