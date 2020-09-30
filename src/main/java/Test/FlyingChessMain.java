package Test;

import FlyingChess.ChessConfig;
import javafx.util.Pair;

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
        config.setSteps(18);
        config.setConsume(20);
        config.setFinishReward(200);
        Map<Integer, Integer> rewards = new HashMap<>();
        rewards.put(6, 20);
//        rewards.put(14, 100);
        config.setRewards(rewards);
        Map<Integer, Integer> retreats = new HashMap<>();
        retreats.put(8, 3);
        retreats.put(12, 3);
        config.setRetreats(retreats);

        int count = 20;  // 用户参与次数

        System.out.println("格子总数：" + config.getSteps());
        System.out.println("摇骰子单次消费：" + config.getConsume() + "鱼翅");
        System.out.println("每圈结束奖励：" + config.getFinishReward() + "鱼翅");
        System.out.println("骰子范围：" + config.getDice());
        System.out.println("奖励节点：" + config.getRewards());
        System.out.println("回退节点：" + config.getRetreats());
        System.out.println("测试次数：" + count + "次");

        System.out.println(count + "次总盈利：" + statisticData(config, count) + "鱼翅");
    }

    public static long statisticData(ChessConfig config, int count) {

        long profit = 0;
        int start = 0;
        for (int i = 0; i < count; i++) {
            System.out.println("/******************************** i = " + i + ", start = " + start + "*********************************/");
            Pair<Integer, Integer> res = play(config, start);
            start = res.getKey();
            profit += res.getValue();
        }
        return profit;
    }

    /**
     * Pair<Integer, Integer>
     *     Pair<当前位置, 盈利>
     * @param config
     * @return
     */
    public static Pair<Integer, Integer> play(ChessConfig config, int start) {

        int income = config.getConsume();
        int cost = 0;

        // 摇骰子-计算向前几步
        int forward = rolling(config.getDice());
        System.out.println("向前步数：" + forward + "步");

        // 当前位置
        int current = start + forward;
        if (current >= config.getSteps()) {
            System.out.println("一圈结束, current = " + current);
            cost += config.getFinishReward();
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
        System.out.println("本次完成，start = " + start + ", current = " + current + ", income = " + income + ", cost = " + cost + ", profit = " + (income - cost));
        return new Pair<>(current, income - cost);
    }

    public static int rolling(Pair<Integer, Integer> dice) {
        Random rd = new Random();
        int i = rd.nextInt(dice.getValue() - dice.getKey() + 1);
        return dice.getKey() + i;
    }
}
