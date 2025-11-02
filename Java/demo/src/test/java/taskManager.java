import com.sky.TaskManagerDoubly;
import org.junit.Test;

public class taskManager {

    @Test
    public void testTaskManager() {
        TaskManagerDoubly taskManager = new TaskManagerDoubly();

        System.out.println("=== 添加任务 ===");
        taskManager.addTask(101, "编写项目需求文档");
        taskManager.addTask(102, "设计数据库表结构");
        taskManager.addTask(103, "开发用户登录模块");
        taskManager.addTask(104, "实现任务管理功能");
        taskManager.addTask(105, "撰写单元测试");

        taskManager.printTasks();

        System.out.println("\n=== 删除任务：ID=102 ===");
        taskManager.deleteTask(102);
        taskManager.printTasks();

        System.out.println("\n=== 再添加两个任务 ===");
        taskManager.addTask(106, "前后端接口联调");
        taskManager.addTask(107, "部署上线与发布说明");

        taskManager.printTasks();

        System.out.println("\n=== 删除不存在的任务：ID=999 ===");
        taskManager.deleteTask(999);  // 用于测试异常或无效删除情况
        taskManager.printTasks();
    }
}
