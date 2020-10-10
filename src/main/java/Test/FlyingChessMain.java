package Test;

import FlyingChess.ChessConfig;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import javafx.util.Pair;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @anchor zhangyaosheng
 * @desc
 * @date 2020/9/27
 * @time 12:27 上午
 * @copyright douyu.com
 */
public class FlyingChessMain {

    public static void main(String[] args) {

        ChessConfig config = new ChessConfig();
        Pair<Integer, Integer> dice = new Pair<>(1, 6);
        config.setDice(dice);
        config.setSteps(24);
        config.setConsume(2000);
        config.setFinishReward(2000);
        Map<Integer, Integer> rewards = new HashMap<>();
        rewards.put(0, 2000);
        rewards.put(5, 100);
        rewards.put(12, 1000);
        rewards.put(17, 60);
        config.setRewards(rewards);
        Map<Integer, Integer> retreats = new HashMap<>();
        retreats.put(11, 3);
        retreats.put(19, 3);
        config.setRetreats(retreats);
        Map<Integer, List<Integer>> forwards = new HashMap<>();
        forwards.put(4, Lists.newArrayList(2));
        forwards.put(7, Lists.newArrayList(1,2,3,4,5,6));
        forwards.put(14, Lists.newArrayList(1,3));
        config.setForwards(forwards);

        int count = 500000;  // 用户参与次数

        System.out.println("格子总数：" + config.getSteps());
        System.out.println("摇骰子单次消费：" + config.getConsume() + "鱼翅");
        System.out.println("骰子范围：" + config.getDice());
        System.out.println("奖励节点：" + config.getRewards());
        System.out.println("回退节点：" + config.getRetreats());
        System.out.println("前进节点：" + config.getForwards());
        System.out.println("测试次数：" + count + "次");

        statisticData(config, count);
    }

    public static void statisticData(ChessConfig config, int count) {

        long startTime = System.currentTimeMillis();
        long income = 0;  // 公司获得的收入
        long cost = 0;  // 公司的产出
        int start = 0;
        int round = 0;
        int rewardRound = 0;
        for (int i = 0; i < count; i++) {
            System.out.println("/******************************** i = " + i + ", start = " + start + "*********************************/");
//            Map<String, Integer> res = play(config, start, round, rewardRound);
            Map<String, Integer> res = playNotAllIn(config, start, round, rewardRound);
            start = res.getOrDefault("current", 0);
            round = res.getOrDefault("round", 0);
            rewardRound = res.getOrDefault("rewardRound", 0);
            income += res.getOrDefault("income", 0);
            cost += res.getOrDefault("cost", 0);
        }
        System.out.println("/******************************** GAME OVER *********************************/");
        double rate = 99999;
        if (cost != 0) {
            rate = new BigDecimal(income).divide(new BigDecimal(cost), 10, RoundingMode.HALF_UP).doubleValue();
        }
        System.out.println("总耗时：" + (System.currentTimeMillis() - startTime) + "ms");
        System.out.println("总投入：" + income + "；总产出：" + cost + "；总圈数：" + round);
        System.out.println(count + "次投产比为：" + rate);
    }

    /**
     * Pair<Integer, Integer>
     *     Pair<当前位置, 盈利>
     * @param config
     * @return
     */
    public static Map<String, Integer> play(ChessConfig config, int start, int round, int rewardRound) {

        int income = config.getConsume();
        int cost = 0;

        // 摇骰子-计算向前几步
        int forward = rolling(config.getDice());
        System.out.println("向前步数：" + forward + "步");

        // 当前位置
        int current = start + forward;
        if (current >= config.getSteps()) {
            System.out.println("一圈结束, current = " + current);
            round ++;
            cost += config.getFinishReward();
            rewardRound ++;
            current = current - config.getSteps();
        }
        if (config.getRetreats().containsKey(current)) {
            int back = config.getRetreats().get(current);
            current -= back;
            System.out.println("用户回退 " + back + "步，current = " + current);
        }
        if (config.getRewards().containsKey(current)) {
            cost += config.getRewards().get(current);
            System.out.println("用户获得奖励：" + config.getRewards().get(current) + "，current = " + current);
        }
        System.out.println("本次完成，start = " + start + ", current = " + current + ", income = " + income + ", cost = " + cost);
        return ImmutableMap.of("current", current, "income", income, "cost", cost, "round", round, "rewardRound", rewardRound);
    }

    private static int rolling(Pair<Integer, Integer> dice) {
        Random rd = new Random();
        int i = rd.nextInt(dice.getValue() - dice.getKey() + 1);
        return dice.getKey() + i;
    }


    public static Map<String, Integer> playNotAllIn(ChessConfig config, int start, int round, int rewardRound) {

        int income = config.getConsume();
        int cost = 0;

        // 摇骰子-计算向前几步
        int forward = rolling(config.getDice());
        System.out.println("向前步数：" + forward + "步");

        // 当前位置
        int current = start + forward;
        if (current >= config.getSteps()) {
            System.out.println("一圈结束, current = " + current);
            round += + current / config.getSteps();
            current = current % config.getSteps();
        }
        while (config.getRetreats().containsKey(current) || config.getForwards().containsKey(current)) {
            if (config.getRetreats().containsKey(current)) {
                int back = config.getRetreats().get(current);
                current -= back;
                System.out.println("用户回退 " + back + "步，current = " + current);
            }
            if (config.getForwards().containsKey(current)) {
                int forward2 = randomNum(config.getForwards().get(current));
                current += forward2;
                System.out.println("用户前进 " + forward2 + "步，current = " + current);
            }
        }
        if (config.getRewards().containsKey(current)) {
            cost += config.getRewards().get(current);
            System.out.println("用户获得奖励：" + config.getRewards().get(current) + "，current = " + current);
        }
        System.out.println("本次完成，start = " + start + ", current = " + current + ", income = " + income + ", cost = " + cost);
        return ImmutableMap.of("current", current, "income", income, "cost", cost, "round", round, "rewardRound", rewardRound);
    }


    private static int randomNum(List<Integer> list) {

        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
