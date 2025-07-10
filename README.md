
# 🛒 StockAlert

**StockAlert** é um sistema desenvolvido em Java com o objetivo de reduzir perdas em supermercados causadas por produtos vencidos. A aplicação monitora prazos de validade e envia alertas com antecedência, ajudando na gestão eficiente de estoques.

## 🎯 Objetivo

Evitar o vencimento de produtos nas prateleiras e câmaras frias, garantindo maior controle de estoque, diminuição de prejuízos e melhor planejamento de promoções e remanejamento interno.

## 🚀 Funcionalidades

- Cadastro de produtos com data de validade
- Monitoramento automático de vencimentos
- Alertas com antecedência configurável (ex.: 7 dias antes de vencer)
- Relatórios de produtos próximos do vencimento
- Integração possível com sistemas existentes via arquivos ou API

## 🛠️ Tecnologias Utilizadas

- Java 11+
- Maven
- **Banco de Dados Oracle SQL**
- JDBC (conexão com o banco)
- (Opcional) Docker
- (Em breve) Interface Web

## 📦 Estrutura do Projeto

```
StockAlert/
├── src/
│   ├── main/java/
│   │   └── ... lógica de cadastro, alerta e monitoramento
│   └── test/java/
│       └── ... testes unitários
├── pom.xml
└── README.md
```

## ⚙️ Como Usar

### 1. Clonar o repositório

```bash
git clone https://github.com/henriquecamolez/StockAlert.git
cd StockAlert
```

### 2. Configurar o banco Oracle


- Altere as credenciais e URL de conexão no arquivo de configuração (ou dentro do código, se aplicável):

```properties
db.url=jdbc:oracle:thin:@localhost:1521:XE
db.username=seu_usuario
db.password=sua_senha
```

### 3. Compilar o projeto

```bash
mvn clean package
```

### 4. Executar o sistema

```bash
java -jar target/StockAlert-1.0.0.jar
```

## 📌 Parâmetros e Configurações

- Dias de antecedência para alerta (padrão: 7)
- Canal de notificação: console, e-mail, etc.
- Frequência de verificação
- Configurações de conexão Oracle SQL

## ✅ Testes

Execute os testes com:

```bash
mvn test
```

## 🛠️ Futuras Melhorias

- [ ] Interface Web com painel de controle
- [ ] Integração com sistemas ERP via API
- [ ] Relatórios em PDF/Excel
- [ ] Cadastro de usuários e permissões


Desenvolvido por [Wagner Henrique Camolez](https://github.com/henriquecamolez) 💼
