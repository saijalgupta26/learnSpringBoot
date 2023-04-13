package com.example.mevenproject.serviceTest;

import com.example.mevenproject.repository.StudentRepository;
import com.example.mevenproject.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;



@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class StudentServiceTest {
    @InjectMocks
    private StudentRepository studentRepository;
    @Mock
    private StudentService studentService;
    @Test
    public void createStudentTest(){
//        Mockito.when(mongoFacadeImpl.findByReportId(Mockito.any()))
//                .thenReturn(Optional.of(MockObjectHelper.getHealthReportTransactions()));
//        Mockito.when(transform.transformIntoCreatePaySiRequest(MockObjectHelper.getPurchaseRequest())).thenReturn(new CreatePayStandingInstructionRequest());
//        Mockito.when(restClient.chargeUser(Mockito.any()))
//                .thenReturn(MockObjectHelper.mockBaseResponseFundsTransactionResponse().getPayload().getResponse());
//        Assertions.assertThatCode(() -> {
//            paidHealthReportServiceImpl.createBuy(context,
//                    Optional.of(MockObjectHelper.getPurchaseRequest()));
//        }).doesNotThrowAnyException();

        //Mockito.when(studentRepository.save(Mockito.any())).thenReturn(Optional.of());


    }
    @Test
    public void deleteStudentTest(){

    }
    @Test
    public void updateStudentTest(){

    }

    @Test
    public void getAllStudentTest()
    {

    }
}
