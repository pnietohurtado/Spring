package com.openwebinars.demo.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype") // Proporciona una instancia distinta cada vez que se efectua, en cambio si no está generaremos en modo Singleton
public class Utils {
}
