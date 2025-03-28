# Caxias Lixo Zero – Plataforma Web

Aplicação web desenvolvida para facilitar a divulgação e a gestão dos Ecopontos, além de promover a educação ambiental para os moradores da região da Serra Gaúcha, RS. 
O sistema atende às demandas da ONG Caxias Lixo Zero, integrando funcionalidades para cadastro, gerenciamento e localização dos pontos de coleta de resíduos, bem como para o compartilhamento de conhecimento sobre reciclagem.
<br />
<br />
<img src="https://github.com/user-attachments/assets/1445f807-b709-4173-aca5-b171ea909409" width="600" />

## Sobre

A plataforma foi idealizada e desenvolvida por alunos do Projeto Temático III da Universidade de Caxias do Sul (UCS) no primeiro semestre de 2024. O sistema surgiu a partir da necessidade da ONG Caxias Lixo Zero, que busca melhorar a gestão dos Ecopontos e disseminar práticas de descarte e reutilização dos resíduos.

A aplicação conta com:
- Cadastro de usuários editores e administradores.
- Registro e aprovação de Ecopontos enviados por usuários.
- Mapa interativo para visualização de dados de pontos de coleta.
- Ferramenta educativa ("Reciclopédia") com informações sobre resíduos e dicas de descarte.
- Integração com APIs externas (Google Maps e ViaCEP) para geolocalização e validação de endereços.

## Tecnologias e Dependências

- **Java JDK 17** – Versão LTS utilizada no desenvolvimento.
- **Spring Boot** – Framework para desenvolvimento da aplicação web.
- **Spring Data JPA** – Integração com o banco de dados PostgreSQL.
- **Thymeleaf** – Template engine para geração dinâmica das páginas HTML.
- **JavaScript & jQuery** – Para interatividade e manipulação do DOM.
- **Google Maps JavaScript API** – Exibição e configuração do mapa interativo.
- **Google Geocoding API** – Geolocalização e busca de endereços.
- **ViaCEP API** – Consulta e validação de CEPs.
- **Maven** – Gerenciamento de dependências e build do projeto.


## Demonstração de Telas

### Tela Inicial
- Identidade visual da ONG.
- Seção com o Mapa de Ecopontos, exibindo a localização dos pontos cadastrados.
- Acesso à "Reciclopédia" com informações educativas sobre resíduos.

### Mapa Interativo
- Visualiza os Ecopontos aprovados com localização precisa.
- Permite filtragem por tipo de resíduo e bairro.
- Utiliza a API do Google para centralizar o mapa conforme a localização do usuário.

### Reciclopédia
- Interface organizada em categorias (resíduos comuns, recicláveis, especiais e rejeitos).
- Campo de busca para filtrar os itens em tempo real.
- Cadastro de Ecopontos
- Formulário dividido em etapas: informações gerais, dados de endereço e especificações dos resíduos.
- Validação automática do CEP via API do ViaCEP para preenchimento dos dados do endereço.

### Área do Voluntário
- Tela para gestão dos Ecopontos e resíduos cadastrados.
- Tabela com filtros para análise e aprovação ou rejeição das solicitações.

## Funcionalidades
- **Cadastro e Gerenciamento de Ecopontos:** Registro de novos pontos de coleta, com aprovação e edição via painel administrativo.
- **Mapeamento Interativo:** Exibição de pontos em um mapa dinâmico, com filtros avançados.
- **Reciclopédia:** Ferramenta educativa que lista os tipos de resíduos, com dicas para descarte e reutilização.
- **Integração de APIs:** Uso de Google Maps, Google Geocoding e ViaCEP para enriquecer a experiência e garantir a precisão dos dados.
- **Interface Responsiva:** Design adaptado para acesso via desktop, tablets e smartphones.

## Autores
- **Ezequiel S. Benelli** – [esbenelli@ucs.br](mailto:esbenelli@ucs.br)
- **Francisco F. Milani** – [ffmilani@ucs.br](mailto:ffmilani@ucs.br)
- **Victor S. Menegotto** – [vsmenegotto@ucs.br](mailto:vsmenegotto@ucs.br)

##  Referências Técnicas
- EVANS, E. *Domain-Driven Design: Tackling Complexity in the Heart of Software.* Addison-Wesley, 2003.
- ISO/IEC 25010:2011 – *Systems and software engineering — Systems and software Quality Requirements and Evaluation (SQuaRE) — System and software quality model*. 2011.
- LARMAN, C. *Applying UML and Patterns. An Introduction to Object-oriented Analysis and Design and the Unified Process.* Prentice Hall, 2002.
- MARINESCU, F.; AVRAM, A.*Domain-Driven Design Quickly.* C4Media, 2007.
- SOMMERVILLE, I.*Software Engineering.* 9th. ed. Addison-Wesley, 2010.
- VALENTE, M. T. *Engenharia de Software Moderna: Princípios e Práticas para Desenvolvimento de Software com Produtividade.* 2020.

##  Artigo Técnico de Desenvolvimento
O desenvolvimento da aplicação foi fundamentado no artigo técnico produzido pela equipe, que detalha as etapas de planejamento, especificação, modelagem e implementação. Para consultar o artigo completo, acesse o link abaixo:

<table>
  <tr>
    <td><img src="https://upload.wikimedia.org/wikipedia/commons/8/87/PDF_file_icon.svg" width="30" /></td>
    <td><a href="https://github.com/user-attachments/files/19506120/Artigo_CaxiasLixoZero.pdf" target="_blank"><strong>Artigo.pdf</strong></a></td>
  </tr>
</table>
