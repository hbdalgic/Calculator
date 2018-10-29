import com.etstur.model.Operator;
import com.etstur.model.RequestModel;
import com.etstur.service.CalculateService;
import com.etstur.service.imp.AddServiceImp;
import com.etstur.service.imp.DivideServiceImp;
import com.etstur.service.imp.MultiplyServiceImp;
import com.etstur.service.imp.SubtractServiceImp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class CalculateServiceTest {

    @Autowired
    private CalculateService calculateService;


    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }
    public void initAdd(){
        calculateService = new AddServiceImp();
    }
    public void initDivide(){
        calculateService = new DivideServiceImp();
    }
    public void initMultiply(){
        calculateService = new MultiplyServiceImp();
    }
    public void initSubtract(){
        calculateService = new SubtractServiceImp();
    }
    @Test
    public void testAdd(){
        initAdd();
        RequestModel requestModel = new RequestModel();
        requestModel.setFirstNumber(6);
        requestModel.setSecondNumber(2);
        requestModel.setOperator(Operator.ADD);

        Float result = calculateService.calculate(requestModel);
        assertTrue(result == 8.0f);

    }
    @Test
    public void testDivide(){
        initDivide();
        RequestModel requestModel = new RequestModel();
        requestModel.setFirstNumber(6);
        requestModel.setSecondNumber(2);
        requestModel.setOperator(Operator.DIVIDE);

        Float result = calculateService.calculate(requestModel);
        assertTrue(result == 3.0f);

    }
    @Test
    public void testMultiply(){
        initMultiply();
        RequestModel requestModel = new RequestModel();
        requestModel.setFirstNumber(6);
        requestModel.setSecondNumber(2);
        requestModel.setOperator(Operator.MULTIPLY);

        Float result = calculateService.calculate(requestModel);
        assertTrue(result == 12.0f);

    }
    @Test
    public void testSubtract(){
        initSubtract();
        RequestModel requestModel = new RequestModel();
        requestModel.setFirstNumber(6);
        requestModel.setSecondNumber(2);
        requestModel.setOperator(Operator.SUBTRACT);

        Float result = calculateService.calculate(requestModel);
        assertTrue(result == 4.0f);

    }

}
