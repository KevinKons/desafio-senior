
##Principais EndPoints

### Cadastrar Hospede

* POST "/api/hospede" 
* Espera um JSON com os campos documentos (máximo de 6 caracteres), nome e telefone.

### Editar Hospode

* PUT "/api/hospede/{id}"
* Espera um JSON com as novas informações do hospde

### Excluir Hospede

* DELETE "/api/hospede/{id}"
* Deleta o hospede com o identificador passado como parâmetro na url

### Buscar Todos os Hospedes

* GET "/api/hospedes"
* Retorna todos os hospedes cadastrados

### Buscar Hospedes Atualmente Hospedados

* GET "/api/hospedes/ainda-no-hotel"

### Buscar Hospedes Que Não Estão no Hotel

* GET "/api/hospedes/nao-mais-no-hotel"
* Não está funcionando, a query foi montada mas contém algum erro.

### Criar CheckIn

* POST "/api/checkin"
* Espera um JSON de CheckIn
* O objeto hospede dentro do JSON de CheckIn deve conter pelo menos um dos seguintes campos:
documento, nome ou telefone.
* Caso existe mais de um hospede com o mesmo nome ou telefone será utilizado o primeiro da 
consulta.
