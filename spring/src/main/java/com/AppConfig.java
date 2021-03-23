package com;

import com.tuu.importselect.MyImportSelect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@ComponentScan("com.ttu")
@Import(MyImportSelect.class)
public class AppConfig {



}
