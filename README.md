# Sistema de Clínica de Saúde

O projeto é composto por várias APIs interconectadas, cada uma desempenhando um papel crucial no funcionamento do sistema.

## API Eureka

A API Eureka tem a responsabilidade de registrar todas as APIs do sistema. Ela atua como um serviço de descoberta, permitindo que outras partes do sistema localizem e se comuniquem com as APIs disponíveis.

## API Gateway

A API Gateway é responsável por direcionar as solicitações recebidas pelos clientes para os serviços apropriados. Ela desempenha um papel crucial na roteamento eficiente e na gestão de tráfego, garantindo uma experiência contínua para os usuários.

## API Funcionário

A API Funcionário é encarregada do cadastro de funcionários no sistema de clínica de saúde. Ela gerencia as informações essenciais dos funcionários, proporcionando uma base sólida para o gerenciamento de recursos humanos.

## API Gerador

A API Gerador desempenha um papel crucial na geração de números únicos para cada funcionário. Esses números são utilizados para identificação única e são fundamentais para diversos processos dentro do sistema.

## API Governança

A API Governança é responsável por gerenciar todo o controle de acessos das APIs. Ela implementa políticas de segurança, autenticação e autorização, garantindo que apenas usuários autorizados tenham acesso aos recursos do sistema.

---

**Nota:** Certifique-se de documentar cada API adequadamente, incluindo detalhes sobre os pontos de extremidade, métodos suportados, autenticação necessária e exemplos de solicitações e respostas. Isso facilitará a compreensão e o uso do sistema por outros desenvolvedores.
