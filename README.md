# Projeto de Teste com Java, Selenium e JUnit

E aí, pessoal! 👋 Bem-vindos ao nosso super projeto de testes! Iremos utilizar Java, Selenium e JUnit para automatizar aquelas interações incríveis com interfaces web.

## Antes de Começar

Bora lá! Mas antes de decolar, certifique-se de ter as seguintes ferramentas instaladas na sua nave:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Apache Maven](https://maven.apache.org/download.cgi)
- [WebDriver (tipo o ChromeDriver)](https://sites.google.com/chromium.org/driver/)

## Estrutura do Projeto

Beleza, vamos entender a bagunça organizada aqui:

- `src/test/java`: Aqui é onde os testes mágicos acontecem.
    - `webdriver`: Implementações das interfaces e a mágica do Selenium.
    - `Base`: Classe base pra todas as outras.
  - `sistema`: Testes específicos pra cada pedacinho do sistema.
    - `modulo`: Cada pedacinho do sistema é um módulo.
      - `tela`: E cada tela é um submódulo.
        - `Modelo`: Tá aqui todos os detalhes da tela.
        - `Utils`: Onde mora a inteligência do teste, estendendo os `Utilitarios`.
        - `Test`: Classe de teste, estendendo `BaseTest`.
        - `.xlsx` ou `.json` : Massa de dados pro teste. Precisamos disso, né?

## Praticando com o Pacote webdriver
Agora, no pacote webdriver, é onde a gente dá vida aos componentes. Implementações e tal, saca?
```
E não esquece de fazer todas as classes pageObject estenderem BasePage.

## Testes Reais no Pacote sistema
No pacote sistema, é onde a mágica real acontece. Testes específicos pra cada telinha.

## Partiu Teste Integrado! 🚀
Chegamos no pacote SISTEMA_INTEGRADO, a área onde a mágica realmente acontece! 🌟 É aqui que nossos testes se tornam verdadeiros aventureiros, explorando e interagindo com todo o sistema.

Vamo nessa?

- Crie Subpacotes pra Cada Plano de Teste:
Cada subpacote representa uma aventura diferente!
- Hora de Codificar na Classe TesteIntegrado:
Dentro do subpacote, cria a classe TesteIntegrado.
Essa classe é tipo o capitão dos testes, estendendo a classe BaseTest.
Agora, implementa os testes como se fosse um contador de histórias!
##### Exemplo:
```java
// Classe de teste para o sistema integrado
public class TesteIntegrado extends BaseTest {

    @Test
    public void testeMegaIntegrado() {
        // Nosso teste começa aqui, meu amigo!

        // Interage com diferentes módulos e telas
        // ...
        
        // Faz umas verificações e asserts
        // ...

        // Conta uma piada (opcional, mas altamente recomendado)
        // 😄🎉

        // Mais interações e verificações
        // ...

        // Termina o teste com chave de ouro
        // ...
    }

    // Adiciona mais testes épicos!
    // ...
}
```














