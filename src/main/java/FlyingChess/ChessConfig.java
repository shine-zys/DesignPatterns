package FlyingChess;

import javafx.util.Pair;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @anchor zhangyaosheng
 * @desc
 * @date 2020/9/27
 * @time 12:28 上午
 * @copyright douyu.com
 */
@Data
public class ChessConfig implements Serializable {

    /**
     * 单圈总步数
     */
    private int steps;

    /**
     * 骰子起止范围
     */
    private Pair<Integer, Integer> dice;

    /**
     * 使用一次骰子消耗的价值
     */
    private int consume;

    /**
     * 完成一圈可获得的奖励
     */
    private int finishReward;

    /**
     * 奖励节点及价值
     */
    private Map<Integer, Integer> rewards = new HashMap<>();

    /**
     * 回退节点及步数
     */
    private Map<Integer, Integer> retreats = new HashMap<>();
}
