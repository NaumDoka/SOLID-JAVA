# SOLID-JAVA
Questo programma Java è un'implementazione semplificata di un sistema di gestione dei progetti. È pensato solo per illustrare l'uso dei principi SOLID e dei design pattern. Struttura:

Classi:
Progetto: Rappresenta un progetto con un ID, un nome e una data di creazione.
Attività: Rappresenta un'attività con un nome e una descrizione.

Classe Factory:
TaskFactory: Fornisce un metodo per creare una nuova istanza di attività basata su un nome di attività. Crea un'attività con una descrizione predefinita.
Interfacce e implementazioni del repository:

ProjectRepository: Definisce i metodi per trovare e salvare i progetti.
ProjectRepositoryImplementation: Implementa l'interfaccia ProjectRepository utilizzando un elenco di progetti in memoria.
Interfacce e implementazioni del servizio:

ProjectService: Definisce i metodi per trovare e salvare i progetti.
Implementazione di ProjectService: Implementa l'interfaccia ProjectService, delegando le operazioni al ProjectRepository.

Pattern Singleton:
SingletonProject: Estende la classe Project e implementa il modello Singleton. Assicura che esista una sola istanza di un progetto alla volta e fornisce metodi per ottenere e impostare i compiti associati al progetto.

Implementazione del servizio compiti:
TaskServiceImplementation: Implementa l'interfaccia TaskService. Fornisce un metodo per ottenere le attività associate a un progetto. Utilizza una TaskFactory per creare i compiti, se non vengono trovati nel SingletonProject.
Nel complesso, questo programma fornisce una struttura di base per la gestione dei progetti e dei compiti all'interno di tali progetti, con funzionalità per la creazione, il recupero e l'aggiornamento dei progetti e dei compiti associati.

Incorpora diversi design pattern e aderisce a diversi principi SOLID:
Singleton Pattern:
La classe SingletonProject implementa il pattern Singleton per garantire che esista una sola istanza di un progetto alla volta.

Factory Method Pattern::
La classe TaskFactory implementa il pattern Factory Method per creare istanze di task in base a un nome di task dato.

Single Responsibility Principle  (SRP):
Ogni classe sembra avere una singola responsabilità. Ad esempio, la classe TaskFactory è responsabile della creazione dei task, le classi del repository gestiscono le operazioni di persistenza e le classi dei servizi gestiscono la logica di business relativa ai progetti e ai task.

Open/Closed Principle (OCP):
Il progetto sembra essere aperto per l'estensione e chiuso per la modifica. Ad esempio, nuovi tipi di compiti o progetti possono essere facilmente aggiunti estendendo le classi esistenti piuttosto che modificandole.

Liskov Substitution Principle (LSP):
La classe Project e le sue sottoclassi (ad esempio, SingletonProject) sembrano aderire al LSP, il che significa che gli oggetti delle sottoclassi possono essere sostituiti agli oggetti della classe base senza influire sulla correttezza del programma.

Interface Segregation Principle (ISP):
Le interfacce del repository e del servizio (ProjectRepository, ProjectService, TaskService) sono focalizzate e contengono solo i metodi rilevanti per le rispettive responsabilità. Questo evita che i clienti siano costretti a dipendere da interfacce che non utilizzano.

Dependency Inversion Principle (DIP):
Le classi ProjectServiceImplementation e TaskServiceImplementation dipendono da astrazioni (ProjectService, ProjectRepository, TaskService) piuttosto che da implementazioni concrete. Ciò consente di ottenere flessibilità e facilità di test, disaccoppiando i moduli di livello superiore da quelli di livello inferiore.
