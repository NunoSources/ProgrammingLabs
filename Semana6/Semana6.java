1. git config --global user.name nunofontes
2. git config --global user.email fc46413@alunos.fc.ul.pt
3. git config --list
4. mkdir semanaGit 
4. cd semanaGit
4. git init
5. echo "Exemplo de uso" > fc46413.txt
6. cat fc46413.txt
7. echo "credencial fc46413" > READ.ME
7. git add READ.ME
8. git status
9. git rm --cached READ.ME
10. git status
11. echo "fc46413@alunos.fc.ul.pt" > READ.ME2
12. git add READ.ME
12. git add READ.ME2
13. //Dentro do servidor git.alunos.di.fc.ul.pt criei um novo projeto, escolhendo 
13. //a opcao new project, designado UmaCopiaDeMim e dentro deste editei um ficheiro 
13. //README.md com o texto "UmaCopiaDeMim é um clone meu :-)"
14. cd ..
14. mkdir usoDoRemoto
15. cd usoDoRemoto
15. git clone https://git.alunos.di.fc.ul.pt/fc46413/UmaCopiaDeMim.git
16. cd UmaCopiaDeMim
17. git status
18. echo "git clone https://git.alunos.di.fc.ul.pt/fc46413/UmaCopiaDeMim.git" > comando.txt
18. git add comando.txt
19. git commit -m "Ficheiro criado localmente para colocar no servidor"
19. git push origin master
20. //Abrindo o projeto UmaCopiaDeMim, alteramos o ficheiro comando.txt, 
20. //escolhemos a opcao edit e acrescentamos uma explicacao do que faz o comando clone
20. //No ficheiro de respostas adicionei uma frase que explica como procedi
21. git pull origin
22. //Dentro do servidor git.alunos.di.fc.ul.pt criei um novo projeto, escolhendo 
22. //a opcao new project, com o nome SemanaGitproJava
23. //Para clonar este repositorio remoto para o repositorio local dentro do diretorio 
23. //usoDoRemoto, acedi ao eclipse, e na perspetiva Git, escolhi a opcao 
23. //Clone a Git repository, sendo o URI: https://git.alunos.di.fc.ul.pt/fc46413/SemanaGitproJava.git
24. //File -> Import -> Existing Projects into Workspace e importamos o material dado
25. //Na vista do Git, escolhi a opcao Add an existing local repository, 
25. //localizei o repositorio, de seguida com o botao direito no projeto, 
25. //fui a Team > Share Project e preenchi os campos como indicado no guiao
25. //selecionei o projeto e cliquei no simbolo + para fazer add e depois commit, 
25. //escrevendo uma mensagem de commit.
26. //Abri a classe Statistics, escrevi o javadoc e commit
27. //Para consultar o historico, na perspetiva Git, na aba Git RefLog escolhi a opcao 
27. //Show in > History
28. //Para consultar as versoes, com o botao direito escolhi a opcao 
28. //compare to previous versions
30. //Apos efetuar as alteracoes do ponto 29, efetuei o commit and push do projeto, 
30. //para o repositorio remoto
31. //Para consultar o historico, na perspetiva Git, na aba Git RefLog escolhi a opcao 
31. //Show in > History
