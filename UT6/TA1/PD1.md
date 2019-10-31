# UNIDAD TEMÁTICA 6 – CLASIFICACIÓN PARTE I

## PRACTICOS DOMICILIARIOS INDIVIDUALES - 1

Utilizando las clases JAVA provistas por la Cátedra “TClasificador.java” y “GeneradorDatosGenerico.java”, armar un paquete “UT6” para contener los programas de prueba de los algoritmos de clasificación.

Se requiere:

### EJERCICIO 1
Estudiar el funcionamiento de la clase “GeneradorDatosGenerico.java” y responder las siguientes preguntas:
1. ¿cómo se genera un vector monótonamente ascendente

**Se inicializa un arreglo de un tamaño máximo _T_. Se recorre el arreglo desde 0 hasta _T_ (no inclusive) según _i_, y se graba en la posición _i_ del arreglo _i + 1_ (para que comience en 1).**

2. ¿cómo se genera un vector monótonamente descendente?

**Idem anterior, pero se graba _T - i_ en cada posición.**

3. ¿cómo se genera un vector con valores aleatorios? ¿pueden existir claves repetidas? ¿cuál es el orden del tiempo de ejecución de este método?

**Se inicializa un arreglo de booleanos de tamaño máximo _T_ y otro auxiliar para retornar los enteros. Se recorre el arreglo de 0 hasta _T_, por cada _i_ se determina un _j_ aleatorio entre 0 y _T_, y se busca en el arreglo de booleanos si ya existe (o sea, si está false) hasta encontrar el primero que no exista, incrementando _j_ según _(j + 1) % T_. Se graba true en dicha posición encontrada como _j_, y en el arreglo auxiliar se graba como valor la posición encontrada en _j_**

4. ¿cuántos elementos contiene el vector de datos generado?¿cómo se puede modificar esta clase para que la cantidad de elementos del vector sea parametrizable?

**Por defecto contiene lo definido en _TAMANIO_MAX_ que es 32000. Los valores son de 0 a 31999. Se crearon tres métodos sobrecargados que reciben como parámetros un _tamanioMax_ definido por el usuario. Los métodos anteriores ahora generan según _tamanioMax_ o según _TAMANIO_MAX_ si no hay definición del usuario.**

5. ¿cómo podemos verificar que un conjunto está ordenado? ¿cuál sería el orden del tiempo de ejecución
de un algoritmo que lo haga?

**Se puede verificar recorriendo todo el arreglo y preguntando: _(arreglo[i] > arreglo[i + 1])_. Si se evalúa lo anterior, significa que el arreglo no quedó ordenado de forma ascendente. También se puede utilizar _>=_ si se asume que tampoco deberían existir valores repetidos (ocurre así para los tres métodos que generan datos). El orden en el peor caso (de éxito) es de _O(N)_, ya que recorre todo el arreglo.**

_IMPORTANTE: LA COMPRENSIÓN PROFUNDA DE ESTAS CLASES JAVA Y LOS ALGORITMOS INVOLUCRADOS SERÁ IMPRESCINDIBLE PARA UNA CORRECTA EJECUCIÓN DE LOS EJERCICIOS EN EQUIPO EN LA PROXIMA CLASE_

### EJERCICIO 2
La clase “TClasificador.java” contiene ya métodos para los algoritmos de inserción directa, shellsort y burbuja. Estos métodos contienen errores.
1. Declarar un vector estático en el “main” con unas pocas (no más de 5) claves enteras, desordenadas
1. Probar la ejecución del método “clasificar” del TClasificador, para invocar el método Inserción Directa.
1. Observar el resultado emitido por consola.
1. Encontrar y reparar los eventuales errores en el método “OrdenarPorInsercion”
1. Volver a ejecutar, y verificar el orden de la salida mediante la ejecución de un método “estaOrdenado” que tome como parámetro el vector resultante de la ordenación.
1. Probar la ejecución con vectores con datos ascendentes, descendentes y aleatorios. Desarrollar casos de test
para verificar el correcto funcionamiento.
1. ¿cuál es el tiempo de ejecución para cada tipo de vector (tamaño y orden)?
1. Repetir los pasos 1 a 7 para los métodos Shellsort y Burbuja.

_NOTA: SE SUGIERE UTILIZAR CONJUNTOS DE DATOS PEQUEÑOS PARA REALIZAR LAS PRIMERAS PRUEBAS. DOCUMENTAR LO OBSERVADO EN CADA UNO DE LOS PUNTOS INDICADOS EN UN DOCUMENTO Y SUBIRLO A LA TAREA CORRESPONDIENTE._

_IMPORTANTE: LA COMPRENSIÓN PROFUNDA DE ESTAS CLASES JAVA Y LOS
ALGORITMOS INVOLUCRADOS SERÁ IMPRESCINDIBLE PARA UNA CORRECTA
EJECUCIÓN DE LOS EJERCICIOS EN EQUIPO EN LA PROXIMA CLASE_
