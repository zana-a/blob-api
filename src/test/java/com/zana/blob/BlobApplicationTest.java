package com.zana.blob;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("dev")
public class BlobApplicationTest {

  @Autowired
  private ApplicationContext applicationContext;

  @Test
  public void contextLoads() {
    assertNotNull(applicationContext);
  }
}
