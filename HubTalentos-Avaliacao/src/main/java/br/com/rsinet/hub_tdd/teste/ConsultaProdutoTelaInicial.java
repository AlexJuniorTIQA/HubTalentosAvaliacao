package br.com.rsinet.hub_tdd.teste;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_tdd.files.Constant;
import br.com.rsinet.hub_tdd.files.ExcelUtils;
import br.com.rsinet.hub_tdd.files.Screenshot;
import br.com.rsinet.hub_tdd.page.DriverElement;
import br.com.rsinet.hub_tdd.page.HomePage;
import br.com.rsinet.hub_tdd.page.ProductPage;


public class ConsultaProdutoTelaInicial {

	private WebDriver driver;
	

	@Before
	public void Inicializa() throws Exception {
		
		driver = DriverElement.getChromeDriver();
	}
	
	@After
	public void finaliza() {
		DriverElement.quitDriver(driver);
	}
	@Test
	public void ConsultarProdutoSucesso ()throws Exception  {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);
		ExcelUtils.setExcelFile(Constant.File_DataUserRegister,"Mice");		

		homePage.clickMice();
		homePage.findElementLinkText(ExcelUtils.getCellData(3, 1));
		
		productPage.assertEqualsProduct(ExcelUtils.getCellData(3, 1));
		Screenshot.getScreenShot(driver, "TesteConsultaTelaPrincipalSucesso ");
	}
	
	@Test
	public void ConsultarProdutoFalha ()throws Exception  {
		ProductPage productPage = PageFactory.initElements(driver, ProductPage.class);
		ExcelUtils.setExcelFile(Constant.File_DataUserRegister,"Mice");
		
		productPage.ClickEelementHPEliteBookFolioDetails();
		productPage.assertEqualsProduct("HP CHROMEBOOK 14 G1(ES)");
		Screenshot.getScreenShot(driver, "TestaConsultaTelaPrincipalFalha");

	}
}
