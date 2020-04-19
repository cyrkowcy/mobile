package pl.edu.pk.mobile.tourtool

import com.github.tomakehurst.wiremock.WireMockServer
import junit.framework.Assert.assertNotNull
import org.junit.Test

class ExampleWireMockTest {

  @Test
  fun wireMockServerWorkingTest() {
    var wireMockServer = WireMockServer()
    wireMockServer.start()
    assertNotNull(wireMockServer)
    wireMockServer.stop()
  }
}
