package com.sosimplebox.p004_import;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//@Import({TestA.class})
@Import({TestA.class, TestB.class})
@Configuration
public class ImportConfig {

}
