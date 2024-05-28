# Conversor de Monedas

## Descripción General

El Conversor de Monedas es una aplicación basada en Java que utiliza la API de ExchangeRate-API para proporcionar conversión de monedas en tiempo real. Esta herramienta está diseñada para ser eficiente, fácil de usar e interactiva, convirtiéndose en un recurso valioso para cualquiera que necesite conversiones de moneda rápidas.

## Características

- **Tasas de Cambio en Tiempo Real**: Obtiene las tasas de cambio más recientes de ExchangeRate-API.
- **Interfaz Amigable**: Interfaz simple de consola para facilidad de uso.
- **Conversiones Precisas**: Convierte cantidades entre varias monedas con precisión.

## Requisitos

- **Java**: Versión 11 o superior.
- **Biblioteca Gson**: Para manejar datos JSON.

## Comenzando

### Prerrequisitos

Antes de comenzar, asegúrate de cumplir con los siguientes requisitos:

- Java 11 o superior instalado. Puedes descargarlo desde [Oracle](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
- Biblioteca Gson. Si estás usando Maven, incluye la dependencia en tu `pom.xml`. De lo contrario, descarga el archivo JAR desde [Maven Central](https://search.maven.org/artifact/com.google.code.gson/gson).

### Instalación

1. **Clona el Repositorio**:

    ```bash
    git clone https://github.com/tu-usuario/tu-repositorio.git
    cd tu-repositorio
    ```

2. **Añadir la Biblioteca Gson**:

    Si no estás usando Maven, descarga el archivo JAR de Gson y colócalo en un directorio `lib` dentro de tu proyecto.

3. **Compila el Proyecto**:

    ```bash
    javac -cp .:lib/gson-2.8.6.jar CurrencyConverter.java
    ```

4. **Ejecuta la Aplicación**:

    ```bash
    java -cp .:lib/gson-2.8.6.jar CurrencyConverter
    ```

### Uso

Sigue las instrucciones en pantalla para ingresar la moneda de origen, la moneda de destino y la cantidad que deseas convertir. La aplicación mostrará la cantidad convertida basada en las tasas de cambio más recientes.

## Ejemplo

```plaintext
Ingrese la moneda de origen (por ejemplo, USD): USD
Ingrese la moneda de destino (por ejemplo, EUR): EUR
Ingrese la cantidad: 100
100.00 USD es igual a 92.30 EUR
