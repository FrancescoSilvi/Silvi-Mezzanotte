---


---

<h1 id="specifiche-del-progetto">Specifiche del progetto</h1>
<p>Il progetto da noi realizzato consiste in un’applicazione REST, progettata in Java e con l’aiuto di Spring-Boot, un framework che ci permetterà di eseguire la Web App.</p>
<p>Parliamo quindi di un Web Service, ovvero un software in grado di mettersi al servizio di un Client (applicazione, sito web), comunicando tramite protocollo HTTP e sfruttandone le funzioni messe a disposizione.</p>
<p>Dato in ingresso un <em>URL</em> contenente dati in formato <em>JSON</em>, verra effettuato il download di un file (se non già presente) contente un dataset in formato CSV. Se invece il file è gia stato scaricato, non sarà necessario eseguire un nuovo download.</p>
<p>A download completato viene effettuato il parsing dei dati del dataset sfruttando apposite classi per consentire all’utente di richiedere operazioni per riottenere dati in formato JSON, come ad esempio:</p>
<ul>
<li>Restituzione dei metadati</li>
<li>Restituzione dei dati riguardanti ogni record</li>
<li>Restituzione dei dati riguardanti record filtrati</li>
<li>Restituzione delle statistiche sui dati di uno specifico campo</li>
<li>Restituzione delle statistiche sui dati di uno specifico campo, su record filtrati</li>
</ul>
<p>Nel nostro caso il data-set rappresenta il contributo del settore della pesca in diversi paesi dal 2000 al 2017, sia in termini di milioni di euro che di percentuale sul PIL. I dati si dividono per:</p>
<ul>
<li>Paese</li>
<li>Unità di misura (milioni di euro o percentuale del PIL),</li>
<li>Anno</li>
</ul>
<h1 id="avvio-del-programma">Avvio del programma</h1>
<p>Per eseguire il software basta lanciare il file .jar ottenuto dal codice sviluppato.</p>
<p>Oppure si può fare ciò partendo dall’ambiente di sviluppo fornito da Eclipse tramite il comando Run As -&gt; Spring Boot APP.</p>
<p>La Web App si attiva in ascolto alla porta <a href="http://localhost:8080">http://localhost:8080</a>.</p>
<p>Sarà poi necessario un software di API testing (nel nostro caso è stato utilizzato Postman) per eseguire le richieste GET.</p>
<h1 id="operazioni-eseguibili">Operazioni eseguibili</h1>
<p>Nella seguente tabella sono riassunte le opzioni richiedibili dal client:</p>

<table>
<thead>
<tr>
<th>Funzione</th>
<th>Tipo</th>
<th>Rotta</th>
</tr>
</thead>
<tbody>
<tr>
<td><strong>Dati</strong></td>
<td>GET</td>
<td>/data</td>
</tr>
<tr>
<td><strong>Metadati</strong></td>
<td>GET</td>
<td>/metadata</td>
</tr>
<tr>
<td><strong>Filtri per unità di misura</strong></td>
<td>GET</td>
<td>/data?unità="…"&amp;CampoRic="…"&amp;operator="…"&amp;val="…"</td>
</tr>
<tr>
<td><strong>Filtri</strong></td>
<td>GET</td>
<td>/data?CampoRic="…"&amp;operator="…"&amp;val="…"</td>
</tr>
<tr>
<td><strong>Statistiche</strong></td>
<td>GET</td>
<td>/stats?unità="…"&amp;anno="…"</td>
</tr>
<tr>
<td><strong>Statistiche filtrate</strong></td>
<td>GET</td>
<td>/stats?unità="…"&amp;anno="…"&amp;CampoRic="…"&amp;operator="…"&amp;val="…"</td>
</tr>
<tr>
<td><strong>Occorrenze</strong></td>
<td>GET</td>
<td>/occ?Colonna="…"</td>
</tr>
<tr>
<td><strong>Occorrenze filtrate</strong></td>
<td>GET</td>
<td>/occ?Colonna="…"&amp;CampoRic="…"&amp;operator="…"&amp;val="…"</td>
</tr>
</tbody>
</table><p>Sono accettati i seguenti valori:</p>
<ul>
<li><strong>Colonna</strong>: freq / geo / unit</li>
<li><strong>unità</strong>: % o €</li>
<li><strong>anno</strong>: 2000…2017</li>
</ul>
<p>Per quanto riguarda il filtraggio, i parametri passabili sono i seguenti:</p>

<table>
<thead>
<tr>
<th>CampoRic</th>
<th>operator</th>
<th>val</th>
</tr>
</thead>
<tbody>
<tr>
<td>freq / geo / unit / 2000…2017</td>
<td>in / nin / lt / lte / gt / gte</td>
<td>valore numerico o stringa di riferimento</td>
</tr>
</tbody>
</table><p><strong>N:B:</strong> Per le statistiche è indispensabile inserire il filtro sull’unità di misura (ad esempio non avrebbe senso fare una media tra milioni di euro e percentuali).</p>
<p>Gli operatori hanno i seguenti significati:</p>

<table>
<thead>
<tr>
<th>Operatore</th>
<th>Descrizione</th>
</tr>
</thead>
<tbody>
<tr>
<td>in</td>
<td>trova il valore richiesto (stringhe/numeri)</td>
</tr>
<tr>
<td>nin</td>
<td>trova tutti i valori diversi da quelli richiesti (stringhe/numeri)</td>
</tr>
<tr>
<td>gt</td>
<td>“&gt;” trova i valori maggiori di quello richiesto</td>
</tr>
<tr>
<td>gte</td>
<td>“&gt;=” trova i valori maggiori o uguali di quello richiesto</td>
</tr>
<tr>
<td>lt</td>
<td>“&lt;” trova i valori minori di quello richiesto</td>
</tr>
<tr>
<td>lte</td>
<td>“&lt;=” trova i valori minori o uguali di quello richiesto</td>
</tr>
</tbody>
</table><h1 id="diagrammi-uml">Diagrammi UML</h1>
<p>UML è un linguaggio di modellazione orientata agli oggetti che permette di modellare, descrivere e documentare la struttura di un’applicazione o il comportamento di un software.</p>
<p>Graficamente ci permettte di mettere in evidenza funzionalità, componenti e relazioni del sistema.</p>
<h2 id="use-case-diagram">Use Case diagram</h2>
<p>Questo diagramma rappresenta le possibili interazioni tra utente e sistema nei differenti casi d’uso in cui l’utente è convolto.</p>
<p>In uno Use Case diagram si individuano:</p>
<ul>
<li>Attori: le persone o chiunque abbia un comportamento nei confronti del sistema</li>
<li>Scenario: una sequenza di azioni tra attori e sistema</li>
<li>Use Case: una collezione di scenari di successi e fallimenti, ovvero una sequenza di azioni eseguite dall’attore, che ci permette di capire quali sono i servizi richiesti e forniti</li>
</ul>
<p><img src="https://lh3.googleusercontent.com/lgkWkAGjSNXdQc9TQ-NLJ8Q3V4LN0khB_HRw_N5o0fLDavZU62N7J5W5hTD8Zc3vUyFWVLxqK78U2A" alt="enter image description here" title="USE CASE DIAGRAM"></p>
<h2 id="class-diagram">Class diagram</h2>
<p>Il Class diagram permette di mettere in evidenza le relazioni tra le classi e gli oggetti utilizzati nel software.<br>
Per ciascuna classe sono rappresentati i propri attributi (variabili e metodi), con relativi livelli di visibilità:</p>
<ul>
<li>Public: flag verde</li>
<li>Private: flag rosso</li>
</ul>
<p><img src="https://lh3.googleusercontent.com/DEPD_VgvgRgxGZ_T2cxa7lfl6XkjuperqVcNx8mlU6VNeog6rsoMNngc2Y3RXmrJ6SuwuZlNYkH4gw" alt="enter image description here" title="UML"></p>

