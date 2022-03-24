import modele.exceptions.NonSupporteeException;
import modele.operations.Division;
import modele.operations.Operations;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;

public class DivisionTest {

    @Test
    public void getResultTest() throws NonSupporteeException {
        Operations mockOperation = EasyMock.createMock(Operations.class);
        Division instance = EasyMock.createMockBuilder(Division.class)
                .addMockedMethod("getNomOperation")
                .addMockedMethod("getNext")
                .createMock();

        EasyMock.expect(instance.getNomOperation()).andReturn("Division");
        EasyMock.expect(instance.getNext()).andReturn(mockOperation);
        EasyMock.replay(mockOperation,instance);
        double result = instance.getResultat("Division",4,2);

        Assert.assertEquals(2,result,2);
    }

}
