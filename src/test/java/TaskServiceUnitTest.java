import com.app.factory.TaskFactory;
import com.app.model.Task;
import com.app.model.implmentation.SingletonProject;
import com.app.service.implementation.TaskServiceImplementation;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


class TaskServiceUnitTest {

    @Test
    void givenValueExistsInCache_whenGetProduct_thenDAOIsNotCalled() {
        TaskFactory taskFactory = mock(TaskFactory.class);
        SingletonProject singletonProject = mock(SingletonProject.class);
        Task task = new Task("task1", "description");
        TaskServiceImplementation productService = new TaskServiceImplementation(taskFactory, singletonProject);

        when(singletonProject.getValue(any(), any())).thenReturn(task);

        productService.getTask("product1");

        Mockito.verify(taskFactory, times(0)).getTask(any());
    }
}
