# Coroutines

* Lo que quiero lograr con este proyecto es que al hacer click en el boton __change color__ podemos simular un cambio en la interfaz mientras estamos llamando a una __API__,
bloqueando la app de forma intencional y asi analizar el uso de las __corutinas__.

* Utilizando un ViewModel, en este caso: __MainViewModel__.
* Entonces el objetivo es ver como no bloquear los elementos ni la aplicacion al momento de utilizar las corutinas.

  ### Solucion
  *Cambiar el hilo de procesamiento del llamado de la __Api__ a .IO que es generalmente utilizada para procesos que pueden ser tardios como las llamadas a bases de datos
  de la siguiente manera :
  ```    private suspend fun apiCall() {
        val result = withContext(Dispatchers.IO) {
            delay(5000)
            "Api response"
        }
        resultState = result
    }
  ```
  *al utilizar ```val result = withContext(Dispatchers.IO) ``` el llamado de la api se ejecuta en el hilo .IO el cual ahora evita el crasheo de la app.
  *Para manejar los errores hago uso de un try-catch de la siguiente manera: 
  ```     fun fetchData() {
        viewModelScope.launch {
            try {
                isLoading = true
                apiCall()
            }catch (e:Exception) {
                println("Error ${e.message}")
            } finally {
                isLoading = false
            }
        }
    }
  ```
  
