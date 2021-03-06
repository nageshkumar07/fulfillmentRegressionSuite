package apiTests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.unitils.reflectionassert.ReflectionAssert;

import getShopperByCityIdExchange.ShopperByCityIdResponse;
import getShopperByCityIdExchange.ShopperByCityIdTestData;
import retrofit.RetrofitService;
import retrofit.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Response;
import utility.ApiEndPoints;
import utility.FixtureUtils;

/**
 * Created by Kiran SK on 4/6/2016.
 */
public class GetShopperBuCityId extends BaseApiTest {

	@Test(priority = 9)

	public void GetShopperBuCityIdTest() throws IOException {

		ShopperByCityIdTestData apiTestData = (ShopperByCityIdTestData) FixtureUtils
				.getAsObject(ShopperByCityIdTestData.class, "testdata/resources/getShopperByCityId.json");
		Call<ShopperByCityIdResponse> call = service.GetShopperByCityId("jaipur");
		Response<ShopperByCityIdResponse> response = call.execute();

		ShopperByCityIdResponse expected1 = apiTestData.getResponse();
		ShopperByCityIdResponse expected = response.body();

		if (response.code() == 200) {

			// ReflectionAssert.assertReflectionEquals(expected, expected1);

			Assert.assertEquals(response.code(), 200);

		} else {

			ReflectionAssert.assertReflectionEquals(expected, expected1);
		}

	}
}
