---


---

<h1 id="specifiche-del-progetto">Specifiche del progetto</h1>
<p>Il progetto da noi realizzato consiste in un’applicazione REST, progettata in Java e con l’aiuto di Spring-Boot Framework, il quale permette di eseguire la Web App.</p>
<p>Parliamo quindi di un Web Service, ovvero un software in grado di mettersi al servizio di un Client (applicazione, sito web, Postman), comunicando tramite il protocollo HTTP e sfruttandone le funzioni messe a disposizione.</p>
<p>Dato in ingresso un <em>URL</em> contenente dati in formato <em>JSON</em>, verra effettuato il download di un file (se non già presente) contente un dataset in formato CSV. Se invece il file è gia stato scaricato, non sarà necessario eseguire un nuovo download.</p>
<p>I dati di partenza del dataset vengono elaborati per consentire all’utente di richiedere operazioni per riottenere dati in formato JSON, come ad esempio:</p>
<ul>
<li>Restituzione dei metadati</li>
<li>Restituzione dei dati riguardanti ogni record</li>
<li>
<ul>
<li>Restituzione dei dati riguardanti record filtrati</li>
</ul>
</li>
<li>Restituzione delle statistiche sui dati di uno specifico campo</li>
<li>Restituzione delle statistiche sui dati di uno specifico campo, su record filtrati</li>
</ul>
<p>Nel nostro caso il data-set rappresenta il contributo del settore della pesca in diversi paesi dal 2012 al 2017, sia in termini di milioni di euro che in percentuale sul PIL. I dato si dividono per:</p>
<ul>
<li>Paese</li>
<li>Unità di misura (milioni di euro o percentuale del PIL),</li>
<li>Anno</li>
</ul>
<h1 id="avvio-del-programma">Avvio del programma</h1>
<p>Partendo dall’ambiente di sviluppo fornito da eclipse basta eseguire il codice tramite il comando Run As -&gt; Spring Boot APP.</p>
<p>La Web App si attiva in ascolto alla porta <a href="http://localhost:8080">http://localhost:8080</a>.</p>
<p>Sarà poi necessario un software di API testing (nel nostro caso è stato utilizzato Postman) per eseguire le richieste GET o POST.</p>
<h1 id="operazioni-eseguibili">Operazioni eseguibili</h1>
<p>Nella seguente tabella sono riassunte le possibili opzioni:.</p>

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
<td><strong>Filtri</strong></td>
<td>GET</td>
<td>/data?unità="…"&amp;CampoRic="…"&amp;operator="…"&amp;val="…"</td>
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
</table><p>Sono accettati i seguenti valori:<br>
Colonna: freq / geo / unit<br>
unità: % o €<br>
anno: 2000…2017</p>
<p><strong>N:B:</strong> Si noti che per quanto riguarda le statistiche è indispensabile inserire il filtro sull’unità di misura (ad esempio non avrebbe senso fare una media tra milioni di euro e percentuali).</p>
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
</table><p>La rotta generata da questi filtri sarà</p>
<h2 id="create-files-and-folders">Create files and folders</h2>
<p>The file explorer is accessible using the button in left corner of the navigation bar. You can create a new file by clicking the <strong>New file</strong> button in the file explorer. You can also create folders by clicking the <strong>New folder</strong> button.</p>
<h2 id="switch-to-another-file">Switch to another file</h2>
<p>All your files and folders are presented as a tree in the file explorer. You can switch from one to another by clicking a file in the tree.</p>
<h2 id="rename-a-file">Rename a file</h2>
<p>You can rename the current file by clicking the file name in the navigation bar or by clicking the <strong>Rename</strong> button in the file explorer.</p>
<h2 id="delete-a-file">Delete a file</h2>
<p>You can delete the current file by clicking the <strong>Remove</strong> button in the file explorer. The file will be moved into the <strong>Trash</strong> folder and automatically deleted after 7 days of inactivity.</p>
<h2 id="export-a-file">Export a file</h2>
<p>You can export the current file by clicking <strong>Export to disk</strong> in the menu. You can choose to export the file as plain Markdown, as HTML using a Handlebars template or as a PDF.</p>
<h1 id="synchronization">Synchronization</h1>
<p>Synchronization is one of the biggest features of StackEdit. It enables you to synchronize any file in your workspace with other files stored in your <strong>Google Drive</strong>, your <strong>Dropbox</strong> and your <strong>GitHub</strong> accounts. This allows you to keep writing on other devices, collaborate with people you share the file with, integrate easily into your workflow… The synchronization mechanism takes place every minute in the background, downloading, merging, and uploading file modifications.</p>
<p>There are two types of synchronization and they can complement each other:</p>
<ul>
<li>
<p>The workspace synchronization will sync all your files, folders and settings automatically. This will allow you to fetch your workspace on any other device.</p>
<blockquote>
<p>To start syncing your workspace, just sign in with Google in the menu.</p>
</blockquote>
</li>
<li>
<p>The file synchronization will keep one file of the workspace synced with one or multiple files in <strong>Google Drive</strong>, <strong>Dropbox</strong> or <strong>GitHub</strong>.</p>
<blockquote>
<p>Before starting to sync files, you must link an account in the <strong>Synchronize</strong> sub-menu.</p>
</blockquote>
</li>
</ul>
<h2 id="open-a-file">Open a file</h2>
<p>You can open a file from <strong>Google Drive</strong>, <strong>Dropbox</strong> or <strong>GitHub</strong> by opening the <strong>Synchronize</strong> sub-menu and clicking <strong>Open from</strong>. Once opened in the workspace, any modification in the file will be automatically synced.</p>
<h2 id="save-a-file">Save a file</h2>
<p>You can save any file of the workspace to <strong>Google Drive</strong>, <strong>Dropbox</strong> or <strong>GitHub</strong> by opening the <strong>Synchronize</strong> sub-menu and clicking <strong>Save on</strong>. Even if a file in the workspace is already synced, you can save it to another location. StackEdit can sync one file with multiple locations and accounts.</p>
<h2 id="synchronize-a-file">Synchronize a file</h2>
<p>Once your file is linked to a synchronized location, StackEdit will periodically synchronize it by downloading/uploading any modification. A merge will be performed if necessary and conflicts will be resolved.</p>
<p>If you just have modified your file and you want to force syncing, click the <strong>Synchronize now</strong> button in the navigation bar.</p>
<blockquote>
<p><strong>Note:</strong> The <strong>Synchronize now</strong> button is disabled if you have no file to synchronize.</p>
</blockquote>
<h2 id="manage-file-synchronization">Manage file synchronization</h2>
<p>Since one file can be synced with multiple locations, you can list and manage synchronized locations by clicking <strong>File synchronization</strong> in the <strong>Synchronize</strong> sub-menu. This allows you to list and remove synchronized locations that are linked to your file.</p>
<h1 id="publication">Publication</h1>
<p>Publishing in StackEdit makes it simple for you to publish online your files. Once you’re happy with a file, you can publish it to different hosting platforms like <strong>Blogger</strong>, <strong>Dropbox</strong>, <strong>Gist</strong>, <strong>GitHub</strong>, <strong>Google Drive</strong>, <strong>WordPress</strong> and <strong>Zendesk</strong>. With <a href="http://handlebarsjs.com/">Handlebars templates</a>, you have full control over what you export.</p>
<blockquote>
<p>Before starting to publish, you must link an account in the <strong>Publish</strong> sub-menu.</p>
</blockquote>
<h2 id="publish-a-file">Publish a File</h2>
<p>You can publish your file by opening the <strong>Publish</strong> sub-menu and by clicking <strong>Publish to</strong>. For some locations, you can choose between the following formats:</p>
<ul>
<li>Markdown: publish the Markdown text on a website that can interpret it (<strong>GitHub</strong> for instance),</li>
<li>HTML: publish the file converted to HTML via a Handlebars template (on a blog for example).</li>
</ul>
<h2 id="update-a-publication">Update a publication</h2>
<p>After publishing, StackEdit keeps your file linked to that publication which makes it easy for you to re-publish it. Once you have modified your file and you want to update your publication, click on the <strong>Publish now</strong> button in the navigation bar.</p>
<blockquote>
<p><strong>Note:</strong> The <strong>Publish now</strong> button is disabled if your file has not been published yet.</p>
</blockquote>
<h2 id="manage-file-publication">Manage file publication</h2>
<p>Since one file can be published to multiple locations, you can list and manage publish locations by clicking <strong>File publication</strong> in the <strong>Publish</strong> sub-menu. This allows you to list and remove publication locations that are linked to your file.</p>
<h1 id="markdown-extensions">Markdown extensions</h1>
<p>StackEdit extends the standard Markdown syntax by adding extra <strong>Markdown extensions</strong>, providing you with some nice features.</p>
<blockquote>
<p><strong>ProTip:</strong> You can disable any <strong>Markdown extension</strong> in the <strong>File properties</strong> dialog.</p>
</blockquote>
<h2 id="smartypants">SmartyPants</h2>
<p>SmartyPants converts ASCII punctuation characters into “smart” typographic punctuation HTML entities. For example:</p>

<table>
<thead>
<tr>
<th></th>
<th>ASCII</th>
<th>HTML</th>
</tr>
</thead>
<tbody>
<tr>
<td>Single backticks</td>
<td><code>'Isn't this fun?'</code></td>
<td>‘Isn’t this fun?’</td>
</tr>
<tr>
<td>Quotes</td>
<td><code>"Isn't this fun?"</code></td>
<td>“Isn’t this fun?”</td>
</tr>
<tr>
<td>Dashes</td>
<td><code>-- is en-dash, --- is em-dash</code></td>
<td>– is en-dash, — is em-dash</td>
</tr>
</tbody>
</table><h2 id="katex">KaTeX</h2>
<p>You can render LaTeX mathematical expressions using <a href="https://khan.github.io/KaTeX/">KaTeX</a>:</p>
<p>The <em>Gamma function</em> satisfying <span class="katex--inline"><span class="katex"><span class="katex-mathml"><math><semantics><mrow><mi mathvariant="normal">Γ</mi><mo stretchy="false">(</mo><mi>n</mi><mo stretchy="false">)</mo><mo>=</mo><mo stretchy="false">(</mo><mi>n</mi><mo>−</mo><mn>1</mn><mo stretchy="false">)</mo><mo stretchy="false">!</mo><mspace width="1em"></mspace><mi mathvariant="normal">∀</mi><mi>n</mi><mo>∈</mo><mi mathvariant="double-struck">N</mi></mrow><annotation encoding="application/x-tex">\Gamma(n) = (n-1)!\quad\forall n\in\mathbb N</annotation></semantics></math></span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord">Γ</span><span class="mopen">(</span><span class="mord mathdefault">n</span><span class="mclose">)</span><span class="mspace" style="margin-right: 0.277778em;"></span><span class="mrel">=</span><span class="mspace" style="margin-right: 0.277778em;"></span></span><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mopen">(</span><span class="mord mathdefault">n</span><span class="mspace" style="margin-right: 0.222222em;"></span><span class="mbin">−</span><span class="mspace" style="margin-right: 0.222222em;"></span></span><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord">1</span><span class="mclose">)</span><span class="mclose">!</span><span class="mspace" style="margin-right: 1em;"></span><span class="mord">∀</span><span class="mord mathdefault">n</span><span class="mspace" style="margin-right: 0.277778em;"></span><span class="mrel">∈</span><span class="mspace" style="margin-right: 0.277778em;"></span></span><span class="base"><span class="strut" style="height: 0.68889em; vertical-align: 0em;"></span><span class="mord mathbb">N</span></span></span></span></span> is via the Euler integral</p>
<p><span class="katex--display"><span class="katex-display"><span class="katex"><span class="katex-mathml"><math><semantics><mrow><mi mathvariant="normal">Γ</mi><mo stretchy="false">(</mo><mi>z</mi><mo stretchy="false">)</mo><mo>=</mo><msubsup><mo>∫</mo><mn>0</mn><mi mathvariant="normal">∞</mi></msubsup><msup><mi>t</mi><mrow><mi>z</mi><mo>−</mo><mn>1</mn></mrow></msup><msup><mi>e</mi><mrow><mo>−</mo><mi>t</mi></mrow></msup><mi>d</mi><mi>t</mi> <mi mathvariant="normal">.</mi></mrow><annotation encoding="application/x-tex">
\Gamma(z) = \int_0^\infty t^{z-1}e^{-t}dt\,.
</annotation></semantics></math></span><span class="katex-html" aria-hidden="true"><span class="base"><span class="strut" style="height: 1em; vertical-align: -0.25em;"></span><span class="mord">Γ</span><span class="mopen">(</span><span style="margin-right: 0.04398em;" class="mord mathdefault">z</span><span class="mclose">)</span><span class="mspace" style="margin-right: 0.277778em;"></span><span class="mrel">=</span><span class="mspace" style="margin-right: 0.277778em;"></span></span><span class="base"><span class="strut" style="height: 2.32624em; vertical-align: -0.91195em;"></span><span class="mop"><span style="margin-right: 0.44445em; position: relative; top: -0.001125em;" class="mop op-symbol large-op">∫</span><span class="msupsub"><span class="vlist-t vlist-t2"><span class="vlist-r"><span class="vlist" style="height: 1.41429em;"><span class="" style="top: -1.78805em; margin-left: -0.44445em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight">0</span></span></span><span class="" style="top: -3.8129em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight">∞</span></span></span></span><span class="vlist-s">​</span></span><span class="vlist-r"><span class="vlist" style="height: 0.91195em;"><span class=""></span></span></span></span></span></span><span class="mspace" style="margin-right: 0.166667em;"></span><span class="mord"><span class="mord mathdefault">t</span><span class="msupsub"><span class="vlist-t"><span class="vlist-r"><span class="vlist" style="height: 0.864108em;"><span class="" style="top: -3.113em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span style="margin-right: 0.04398em;" class="mord mathdefault mtight">z</span><span class="mbin mtight">−</span><span class="mord mtight">1</span></span></span></span></span></span></span></span></span><span class="mord"><span class="mord mathdefault">e</span><span class="msupsub"><span class="vlist-t"><span class="vlist-r"><span class="vlist" style="height: 0.843556em;"><span class="" style="top: -3.113em; margin-right: 0.05em;"><span class="pstrut" style="height: 2.7em;"></span><span class="sizing reset-size6 size3 mtight"><span class="mord mtight"><span class="mord mtight">−</span><span class="mord mathdefault mtight">t</span></span></span></span></span></span></span></span></span><span class="mord mathdefault">d</span><span class="mord mathdefault">t</span><span class="mspace" style="margin-right: 0.166667em;"></span><span class="mord">.</span></span></span></span></span></span></p>
<blockquote>
<p>You can find more information about <strong>LaTeX</strong> mathematical expressions <a href="http://meta.math.stackexchange.com/questions/5020/mathjax-basic-tutorial-and-quick-reference">here</a>.</p>
</blockquote>
<h2 id="uml-diagrams">UML diagrams</h2>
<p>You can render UML diagrams using <a href="https://mermaidjs.github.io/">Mermaid</a>. For example, this will produce a sequence diagram:</p>
<div class="mermaid"><svg xmlns="http://www.w3.org/2000/svg" id="mermaid-svg-Qe0IG9SxgwHBwaJe" height="100%" width="100%" style="max-width:750px;" viewBox="-50 -10 750 457"><g></g><g><line id="actor12" x1="75" y1="5" x2="75" y2="446" class="actor-line" stroke-width="0.5px" stroke="#999"></line><rect x="0" y="0" fill="#eaeaea" stroke="#666" width="150" height="65" rx="3" ry="3" class="actor"></rect><text x="75" y="32.5" style="text-anchor: middle;" dominant-baseline="central" alignment-baseline="central" class="actor"><tspan x="75" dy="0">Alice</tspan></text></g><g><line id="actor13" x1="275" y1="5" x2="275" y2="446" class="actor-line" stroke-width="0.5px" stroke="#999"></line><rect x="200" y="0" fill="#eaeaea" stroke="#666" width="150" height="65" rx="3" ry="3" class="actor"></rect><text x="275" y="32.5" style="text-anchor: middle;" dominant-baseline="central" alignment-baseline="central" class="actor"><tspan x="275" dy="0">Bob</tspan></text></g><g><line id="actor14" x1="475" y1="5" x2="475" y2="446" class="actor-line" stroke-width="0.5px" stroke="#999"></line><rect x="400" y="0" fill="#eaeaea" stroke="#666" width="150" height="65" rx="3" ry="3" class="actor"></rect><text x="475" y="32.5" style="text-anchor: middle;" dominant-baseline="central" alignment-baseline="central" class="actor"><tspan x="475" dy="0">John</tspan></text></g><defs><marker id="arrowhead" refX="5" refY="2" markerWidth="6" markerHeight="4" orient="auto"><path d="M 0,0 V 4 L6,2 Z"></path></marker></defs><defs><marker id="crosshead" markerWidth="15" markerHeight="8" orient="auto" refX="16" refY="4"><path fill="black" stroke="#000000" style="stroke-dasharray: 0px, 0px;" stroke-width="1px" d="M 9,2 V 6 L16,4 Z"></path><path fill="none" stroke="#000000" style="stroke-dasharray: 0px, 0px;" stroke-width="1px" d="M 0,1 L 6,7 M 6,1 L 0,7"></path></marker></defs><g><text x="175" y="93" style="text-anchor: middle;" class="messageText">Hello Bob, how are you?</text><line x1="75" y1="100" x2="275" y2="100" class="messageLine0" stroke-width="2" stroke="black" style="fill: none;" marker-end="url(#arrowhead)"></line></g><g><text x="375" y="128" style="text-anchor: middle;" class="messageText">How about you John?</text><line x1="275" y1="135" x2="475" y2="135" style="stroke-dasharray: 3px, 3px; fill: none;" class="messageLine1" stroke-width="2" stroke="black" marker-end="url(#arrowhead)"></line></g><g><text x="175" y="163" style="text-anchor: middle;" class="messageText">I am good thanks!</text><line x1="275" y1="170" x2="75" y2="170" style="stroke-dasharray: 3px, 3px; fill: none;" class="messageLine1" stroke-width="2" stroke="black" marker-end="url(#crosshead)"></line></g><g><text x="375" y="198" style="text-anchor: middle;" class="messageText">I am good thanks!</text><line x1="275" y1="205" x2="475" y2="205" class="messageLine0" stroke-width="2" stroke="black" style="fill: none;" marker-end="url(#crosshead)"></line></g><g><rect x="500" y="215" fill="#EDF2AE" stroke="#666" width="150" height="76" rx="0" ry="0" class="note"></rect><text x="496" y="239" fill="black" class="noteText"><tspan x="516" fill="black">Bob thinks a long</tspan></text><text x="496" y="253" fill="black" class="noteText"><tspan x="516" fill="black">long time, so long</tspan></text><text x="496" y="267" fill="black" class="noteText"><tspan x="516" fill="black">that the text does</tspan></text><text x="496" y="281" fill="black" class="noteText"><tspan x="516" fill="black">not fit on a row.</tspan></text></g><g><text x="175" y="319" style="text-anchor: middle;" class="messageText">Checking with John...</text><line x1="275" y1="326" x2="75" y2="326" style="stroke-dasharray: 3px, 3px; fill: none;" class="messageLine1" stroke-width="2" stroke="black"></line></g><g><text x="275" y="354" style="text-anchor: middle;" class="messageText">Yes... John, how are you?</text><line x1="75" y1="361" x2="475" y2="361" class="messageLine0" stroke-width="2" stroke="black" style="fill: none;"></line></g><g><rect x="0" y="381" fill="#eaeaea" stroke="#666" width="150" height="65" rx="3" ry="3" class="actor"></rect><text x="75" y="413.5" style="text-anchor: middle;" dominant-baseline="central" alignment-baseline="central" class="actor"><tspan x="75" dy="0">Alice</tspan></text></g><g><rect x="200" y="381" fill="#eaeaea" stroke="#666" width="150" height="65" rx="3" ry="3" class="actor"></rect><text x="275" y="413.5" style="text-anchor: middle;" dominant-baseline="central" alignment-baseline="central" class="actor"><tspan x="275" dy="0">Bob</tspan></text></g><g><rect x="400" y="381" fill="#eaeaea" stroke="#666" width="150" height="65" rx="3" ry="3" class="actor"></rect><text x="475" y="413.5" style="text-anchor: middle;" dominant-baseline="central" alignment-baseline="central" class="actor"><tspan x="475" dy="0">John</tspan></text></g></svg></div>
<p>And this will produce a flow chart:</p>
<div class="mermaid"><svg xmlns="http://www.w3.org/2000/svg" id="mermaid-svg-tqufI45MpOGyvNEC" width="100%" style="max-width: 500.9549789428711px;" viewBox="0 0 500.9549789428711 172.59999084472656"><g transform="translate(-12, -12)"><g class="output"><g class="clusters"></g><g class="edgePaths"><g class="edgePath" style="opacity: 1;"><path class="path" d="M120.4875176804892,78.23333358764648L179.31665802001953,49.94166564941406L255.2583236694336,49.94166564941406" marker-end="url(#arrowhead87)" style="fill:none"></path><defs><marker id="arrowhead87" viewBox="0 0 10 10" refX="9" refY="5" markerUnits="strokeWidth" markerWidth="8" markerHeight="6" orient="auto"><path d="M 0 0 L 10 5 L 0 10 z" class="arrowheadPath" style="stroke-width: 1px; stroke-dasharray: 1px, 0px;"></path></marker></defs></g><g class="edgePath" style="opacity: 1;"><path class="path" d="M120.4875176804892,124.94999313354492L179.31665802001953,153.24166107177734L234.79998779296875,153.24166107177734" marker-end="url(#arrowhead88)" style="fill:none"></path><defs><marker id="arrowhead88" viewBox="0 0 10 10" refX="9" refY="5" markerUnits="strokeWidth" markerWidth="8" markerHeight="6" orient="auto"><path d="M 0 0 L 10 5 L 0 10 z" class="arrowheadPath" style="stroke-width: 1px; stroke-dasharray: 1px, 0px;"></path></marker></defs></g><g class="edgePath" style="opacity: 1;"><path class="path" d="M315.1416549682617,49.94166564941406L360.59999084472656,49.94166564941406L408.70982831217043,79.48182589315182" marker-end="url(#arrowhead89)" style="fill:none"></path><defs><marker id="arrowhead89" viewBox="0 0 10 10" refX="9" refY="5" markerUnits="strokeWidth" markerWidth="8" markerHeight="6" orient="auto"><path d="M 0 0 L 10 5 L 0 10 z" class="arrowheadPath" style="stroke-width: 1px; stroke-dasharray: 1px, 0px;"></path></marker></defs></g><g class="edgePath" style="opacity: 1;"><path class="path" d="M335.59999084472656,153.24166107177734L360.59999084472656,153.24166107177734L408.70982831217043,124.7015008280396" marker-end="url(#arrowhead90)" style="fill:none"></path><defs><marker id="arrowhead90" viewBox="0 0 10 10" refX="9" refY="5" markerUnits="strokeWidth" markerWidth="8" markerHeight="6" orient="auto"><path d="M 0 0 L 10 5 L 0 10 z" class="arrowheadPath" style="stroke-width: 1px; stroke-dasharray: 1px, 0px;"></path></marker></defs></g></g><g class="edgeLabels"><g class="edgeLabel" style="opacity: 1;" transform="translate(179.31665802001953,49.94166564941406)"><g transform="translate(-30.48332977294922,-13.358329772949219)" class="label"><foreignObject width="60.96665954589844" height="26.716659545898438"><div xmlns="http://www.w3.org/1999/xhtml" style="display: inline-block; white-space: nowrap;"><span class="edgeLabel">Link text</span></div></foreignObject></g></g><g class="edgeLabel" style="opacity: 1;" transform=""><g transform="translate(0,0)" class="label"><foreignObject width="0" height="0"><div xmlns="http://www.w3.org/1999/xhtml" style="display: inline-block; white-space: nowrap;"><span class="edgeLabel"></span></div></foreignObject></g></g><g class="edgeLabel" style="opacity: 1;" transform=""><g transform="translate(0,0)" class="label"><foreignObject width="0" height="0"><div xmlns="http://www.w3.org/1999/xhtml" style="display: inline-block; white-space: nowrap;"><span class="edgeLabel"></span></div></foreignObject></g></g><g class="edgeLabel" style="opacity: 1;" transform=""><g transform="translate(0,0)" class="label"><foreignObject width="0" height="0"><div xmlns="http://www.w3.org/1999/xhtml" style="display: inline-block; white-space: nowrap;"><span class="edgeLabel"></span></div></foreignObject></g></g></g><g class="nodes"><g class="node" style="opacity: 1;" id="A" transform="translate(71.91666412353516,101.5916633605957)"><rect rx="0" ry="0" x="-51.916664123535156" y="-23.35832977294922" width="103.83332824707031" height="46.71665954589844"></rect><g class="label" transform="translate(0,0)"><g transform="translate(-41.916664123535156,-13.358329772949219)"><foreignObject width="83.83332824707031" height="26.716659545898438"><div xmlns="http://www.w3.org/1999/xhtml" style="display: inline-block; white-space: nowrap;">Square Rect</div></foreignObject></g></g></g><g class="node" style="opacity: 1;" id="B" transform="translate(285.19998931884766,49.94166564941406)"><circle x="-29.941665649414062" y="-23.35832977294922" r="29.941665649414062"></circle><g class="label" transform="translate(0,0)"><g transform="translate(-19.941665649414062,-13.358329772949219)"><foreignObject width="39.883331298828125" height="26.716659545898438"><div xmlns="http://www.w3.org/1999/xhtml" style="display: inline-block; white-space: nowrap;">Circle</div></foreignObject></g></g></g><g class="node" style="opacity: 1;" id="C" transform="translate(285.19998931884766,153.24166107177734)"><rect rx="5" ry="5" x="-50.400001525878906" y="-23.35832977294922" width="100.80000305175781" height="46.71665954589844"></rect><g class="label" transform="translate(0,0)"><g transform="translate(-40.400001525878906,-13.358329772949219)"><foreignObject width="80.80000305175781" height="26.716659545898438"><div xmlns="http://www.w3.org/1999/xhtml" style="display: inline-block; white-space: nowrap;">Round Rect</div></foreignObject></g></g></g><g class="node" style="opacity: 1;" id="D" transform="translate(445.2774848937988,101.5916633605957)"><polygon points="59.677494049072266,0 119.35498809814453,-59.677494049072266 59.677494049072266,-119.35498809814453 0,-59.677494049072266" rx="5" ry="5" transform="translate(-59.677494049072266,59.677494049072266)"></polygon><g class="label" transform="translate(0,0)"><g transform="translate(-32.94999694824219,-13.358329772949219)"><foreignObject width="65.89999389648438" height="26.716659545898438"><div xmlns="http://www.w3.org/1999/xhtml" style="display: inline-block; white-space: nowrap;">Rhombus</div></foreignObject></g></g></g></g></g></g></svg></div>

