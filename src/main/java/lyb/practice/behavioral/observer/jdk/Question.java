package lyb.practice.behavioral.observer.jdk;

/**
 * 项目名称：pattern
 * 功能说明: 问题对象
 * 创建日期：2019/8/19
 *
 * @Author: LYB
 */
public class Question {
    private String asker;

    private String content;

    public String getAsker() {
        return asker;
    }

    public void setAsker(String asker) {
        this.asker = asker;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
