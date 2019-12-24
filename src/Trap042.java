import java.util.Stack;

public class Trap042 {

    public static void main(String[] args) {
        int[] height = new int[]{2,1,0,0,3,2,1,2,1};
        new Trap042().trap(height);
    }

    /**
     * 算法讲解：
     *    每一个下标都入栈，如果碰到下标对应的高度大于栈顶就出栈
     *    出栈后再取一个栈顶，这样三个柱子就进行一个计算，两边的柱子之间的宽度*（最左边柱子的高度-中间柱子的高度），就是这三个柱子之间的面积
     *
     * @return
     */
    public int trap(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        int current = 0;
        while (current < height.length) {
            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.empty() && height[current] > height[stack.peek()]) {
                int h = height[stack.pop()]; //取出要出栈的元素，这个就是三个柱子中间的柱子
                if (stack.empty()) { // 栈空就出去，说明无法形成高低高的三根柱子，无法蓄水
                    break;
                }
                //current是最右边的柱子，stack.peek()是获取的三根柱子的最左边的柱子
                int distance = current - stack.peek() - 1; //两堵墙之前的距离。
                //获取两根柱子中较矮的一根
                int min = Math.min(height[stack.peek()], height[current]);
                //最右与最左中间的距离*（最左柱子的高度减去-中间柱子的高度）
                sum = sum + distance * (min - h);
            }
            stack.push(current); //当前指向的墙入栈
            current++; //指针后移
        }
        return sum;
    }
}
