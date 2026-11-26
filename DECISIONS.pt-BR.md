# Decisões do projeto

[English](DECISIONS.md) · **Português (Brasil)**

Este arquivo registra as decisões importantes tomadas durante o desenvolvimento do projeto. As duas versões devem permanecer sincronizadas.

## 25/11/2026 — Escolha da stack tecnológica

- **Decisão:** Utilizar Java 21, Spring Boot 4.2.0 e Maven no back-end; JavaScript, React e Vite no front-end. A tecnologia do banco de dados ainda está pendente de decisão final.
- **Alternativas consideradas:** Node.js com Express, Python com FastAPI e JavaScript puro, sem React.
- **Motivo:** Java e Spring Boot já estão configurados e funcionando no projeto. React e Vite oferecem uma maneira organizada e prática de desenvolver o frontend utilizando JavaScript.

## 25/11/2026 — Escopo do MVP

- **Decisão:** Desenvolver um sistema de achados e perdidos para o campus e a comunidade, com cadastro de objetos encontrados, descrições auxiliadas por IA e revisadas por uma pessoa, registro de objetos perdidos, busca e filtros, manifestações de interesse e atualização do status de devolução.
- **Alternativas consideradas:** Um sistema menor, limitado ao cadastro de objetos encontrados, ou um sistema mais amplo com serviços adicionais.
- **Motivo:** O escopo escolhido atende aos requisitos principais do hackathon e pode ser desenvolvido dentro do prazo disponível.

## 25/11/2026 — Funcionalidades fora do MVP

- **Decisão:** Não implementar reconhecimento facial, entregas, pagamentos, recompensas, leilões ou funcionalidades de boletim de ocorrência.
- **Alternativas consideradas:** Adicionar essas funcionalidades como serviços opcionais.
- **Motivo:** Essas funcionalidades estão fora dos requisitos do desafio e aumentariam a complexidade e os riscos do projeto.