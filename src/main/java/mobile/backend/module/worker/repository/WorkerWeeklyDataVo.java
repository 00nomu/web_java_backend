package mobile.backend.module.worker.repository;

import lombok.*;

@Data
@NoArgsConstructor
public class WorkerWeeklyDataVo  {
    public weekData 일;
    public weekData 월;
    public weekData 화;
    public weekData 수;
    public weekData 목;
    public weekData 금;
    public weekData 토;

    @Getter
    @NoArgsConstructor
    public static class weekData {
        private String 시업시간;
        private String 종업시간;
        private int 휴게시간_주간_시간;
        private int 휴게시간_주간_분;
        private int 휴게시간_야간_시간;
        private int 휴게시간_야간_분;
        private int 근무시간;
        private Boolean 근무여부;
    }
}
