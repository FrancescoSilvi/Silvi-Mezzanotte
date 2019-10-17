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
<li>Restituzione delle occorrenze in uno specifico campo</li>
<li>Restituzione delle occorrenze in uno specifico campo, su record filtrati</li>
</ul>
<p>Nel nostro caso il data-set rappresenta il contributo del settore della pesca in diversi paesi dal 2000 al 2017, sia in termini di milioni di euro che di percentuale sul PIL. I dati si dividono per:</p>
<ul>
<li>Frequenza di rilevazione (nel nostro caso annuale)</li>
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
<li><strong>Colonna</strong>: freq / geo / unit -&gt; indica il campo su cui effettuare la ricerca delle occorrenze tra quelli elencati</li>
<li><strong>unità</strong>: % o € -&gt; specifica l’unità di misura dei dati da utilizzare per il calcolo delle statistiche o per l’applicazione dei filtri</li>
<li><strong>anno</strong>: 2000…2017 -&gt; permette di scegliere l’anno su cui calcolare le statistiche</li>
</ul>
<p>Per quanto riguarda il filtraggio, va prima di tutto specificata la colonna su quale applicare il filtro (CampoRic); scegliere poi l’operatore (operator) tra quelli disponibili e il valore di riferimento (val).</p>
<p>I parametri accettabili sono i seguenti:</p>

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
</table><h1 id="esempi-test">Esempi test</h1>
<p>In questi esempi sono state testate le funzioni:</p>
<ul>
<li>Stampa i dati<br>
<img src="https://lh3.googleusercontent.com/z89ykN3_IDaUDsLD3dp37LOj1rv_Urs6opefnjTgXFzyDWukgwPDcFPOuenvkrDhbiAv9lMC58wP8A" alt=""><br>
<img src="https://lh3.googleusercontent.com/uHx_dvVeqEFNQQ9rkkGedV-L_ZyUIwEDDz9bseHzJJZF7OmvXHDzPE7IEowk_wuOn2itODHFDp3oXQ" alt="enter image description here"></li>
<li>Stampa i metadati<br>
<img src="https://lh3.googleusercontent.com/qhNkS99zHHYiXY0as-cN7fkQtSM8E5TjXvctI34ZkMnRjcQCalhbSnvOeef_ho2xYAZxioUUzCVlcA" alt="enter image description here"><br>
<img src="https://lh3.googleusercontent.com/8VOORlOLrKxL7p_HAkrJXLnXaw2i1p71s3XeaATQojVhp2Gy9cVKzRzrLvS2MN4jVWS4sS80YCWazg" alt=""></li>
<li>Stampa dei dati relativi ai paesi che nell’anno 2008 avevano un valore cella maggiore o uguale di 10<br>
<img src="https://lh3.googleusercontent.com/Mtmx6Bc0WxwvNa29KA12Y-ISV4ryWhpykV1jb7oq3ubxw_PotKB5OVQFg2Fp6xA3lJ87GToBggPsMw" alt="enter image description here"><br>
<img src="https://lh3.googleusercontent.com/BPN0bFA1Ezjo3uv_mE5P8NPx-Qx7Xrd_0ehNB3GcRpdIxmn4ke-Nn4fR9yxfzx5swe9swL08oxaIBw" alt="enter image description here"></li>
<li>Stampa delle statistiche del paese IT (Italia) nell’anno 2000 riferite ai valori in milioni di euro<br>
<img src="https://lh3.googleusercontent.com/3VE2RESuE-OdztYNsZ_Fh9yKh9nskzJnkh36F9OMK_Q0-3_wYJ2AFN87drmQD7V3-BTK_Er60IcSMQ" alt="enter image description here"><br>
<img src="https://lh3.googleusercontent.com/CPRBMWSX9z4dL6d0rXnXXu4C_e7aAwYo-RWKc16SQwp-zGZh1imL_CCA0eBXGFNO8j2v_BjuRSiUUQ" alt=""></li>
<li>Calcolo delle occorrenze della colonna “geo” sui dati che nell’anno 2010 avevano valore maggiore o uguale di 0,001<br>
<img src="https://lh3.googleusercontent.com/rouPw1gqXi5JDu0jrzRUqHzTxDHr-iScfOhJDpDa1I-FkjY6UZNfV554Mve7AwI-nHklNuh5sBdznQ" alt="enter image description here"><br>
<img src="https://lh3.googleusercontent.com/1LmM0JtMUM77NcDe7w40-I3WgY7E5VtGjK474r90kNtlnnSKqZpW4ZmG074zLK937ryKUgbHJZNmdQ" alt=""></li>
</ul>
<h1 id="diagrammi-uml">Diagrammi UML</h1>
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
<p><img src="https://lh3.googleusercontent.com/9mjxIH_5wiyZOgr7rTt4yV0llFnc88sDMR1N_zsMKzUNjfMMBpYgynRmMwU_0FlQwbJFJT10mZLKiQ" alt=""></p>
<h2 id="activity-diagram">Activity diagram</h2>
<p>L’Activty diagram descrive le azioni compiute dagli attori e illustrate nello Use Case diagram.<br>
Il diagramma illustra la successione temporale-logica delle azioni e il loro svolgimento.</p>
<p><img src="https://lh3.googleusercontent.com/iXsyyNL04cLXuCBlp7CXXrv9yG_ErErlIjdkavHHb4vf0Cxgg6io1PpwXtKp9A6fLCuRR3KdTgqT2g" alt="" title="ACTIVITY DIAGRAM"></p>
<h2 id="packages-diagram">Packages diagram</h2>
<p>In questo diagramma vengono rappresentati i vari package utilizzati per implentare il software e come sono stati organizzati.</p>
<p><img src="https://lh3.googleusercontent.com/VCAqpehyojEtRld01qJ4qvIiQbV_B0haKindC2C6ZgXsUT1EdF1AC2fkZzZHoujAB2ptjWPLeGJP8g" alt="" title="PACKAGES"></p>
<h2 id="class-diagram">Class diagram</h2>
<p>Il Class diagram permette di mettere in evidenza le relazioni tra le classi e gli oggetti utilizzati nel software.<br>
Per ciascuna classe sono rappresentati i propri attributi (variabili e metodi), con relativi livelli di visibilità:</p>
<ul>
<li>Public: flag verde</li>
<li>Private: flag rosso</li>
</ul>
<p><img src="https://lh3.googleusercontent.com/tEV4kL84fJMSW410TbfiULu1IcwxX3LOAku7ZDBLl8Zmk6BuFTVdug17QyZXdpvOocuii2bwf17LIw" alt="enter image description here" title="Class diagram"></p>

