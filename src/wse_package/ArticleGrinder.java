package wse_package;

import java.io.IOException;

import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;
import java.io.StringReader;
import javax.swing.text.html.parser.ParserDelegator;

public class ArticleGrinder {
	private static StringBuilder sb = new StringBuilder();	//output for html to plain text parser
	private static HTMLEditorKit.ParserCallback parserCallback = new HTMLEditorKit.ParserCallback() {
	    public boolean readyForNewline;

	    @Override
	    public void handleText(final char[] data, final int pos) {
	        String s = new String(data);
	        sb.append(s.trim());
	        sb.append(" ");
	        readyForNewline = true;
	    }

	    @Override
	    public void handleStartTag(final HTML.Tag t, final MutableAttributeSet a, final int pos) {
	        if (readyForNewline && (t == HTML.Tag.DIV || t == HTML.Tag.BR || t == HTML.Tag.P)) {
	            sb.append("\n");
	            readyForNewline = false;
	        }
	    }

	    @Override
	    public void handleSimpleTag(final HTML.Tag t, final MutableAttributeSet a, final int pos) {
	        handleStartTag(t, a, pos);
	    }
	};
	
	private static String html_to_text(String html) throws IOException{
		sb.delete(0, sb.length());	//clear sb
		new ParserDelegator().parse(new StringReader(html), parserCallback, false);
		return new String(sb);
		
	}
	
	public static void main(String[] args) throws IOException {
		String html = new String("<p><span id=\"sous_titre_h1\"><i>Cuculus optatus</i></span></p>\n<div class=\"bandeau-article bandeau-niveau-ebauche plainlinks\">\n<div class=\"bandeau-cell bandeau-icone\"><a href=\"/wiki/Fichier:Ruddy-turnstone-icon.png\" class=\"image\"><img alt=\"image illustrant les oiseaux\" src=\"//upload.wikimedia.org/wikipedia/commons/thumb/4/4e/Ruddy-turnstone-icon.png/45px-Ruddy-turnstone-icon.png\" width=\"45\" height=\"30\" srcset=\"//upload.wikimedia.org/wikipedia/commons/thumb/4/4e/Ruddy-turnstone-icon.png/68px-Ruddy-turnstone-icon.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/4/4e/Ruddy-turnstone-icon.png/90px-Ruddy-turnstone-icon.png 2x\" data-file-width=\"180\" data-file-height=\"120\" /></a></div>\n<div class=\"bandeau-cell\"><strong class=\"bandeau-titre\">Cet article est une <a href=\"/wiki/Aide:%C3%89bauche\" title=\"Aide:\u00c9bauche\">\u00e9bauche</a> concernant les <a href=\"/wiki/Ornithologie\" title=\"Ornithologie\">oiseaux</a>.</strong>\n<p>Vous pouvez partager vos connaissances en l\u2019am\u00e9liorant (<b><a href=\"/wiki/Aide:Comment_modifier_une_page\" title=\"Aide:Comment modifier une page\">comment&#160;?</a></b>) selon les recommandations du <a href=\"/wiki/Projet:Ornithologie\" title=\"Projet:Ornithologie\">projet ornithologie</a>.</p>\n</div>\n</div>\n<div class=\"infobox_v3 large taxobox_v3 zoologie animal bordered\" style=\"width:20em\">\n<div class=\"entete\" style=\"\">\n<div><i>Cuculus optatus</i></div>\n</div>\n<div class=\"images\"><a href=\"/wiki/Fichier:Oriental_Cuckoo_front_Maiala.JPG\" class=\"image\"><img alt=\"Description de cette image, \u00e9galement comment\u00e9e ci-apr\u00e8s\" src=\"//upload.wikimedia.org/wikipedia/commons/thumb/e/ee/Oriental_Cuckoo_front_Maiala.JPG/290px-Oriental_Cuckoo_front_Maiala.JPG\" width=\"290\" height=\"248\" srcset=\"//upload.wikimedia.org/wikipedia/commons/thumb/e/ee/Oriental_Cuckoo_front_Maiala.JPG/435px-Oriental_Cuckoo_front_Maiala.JPG 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/e/ee/Oriental_Cuckoo_front_Maiala.JPG/580px-Oriental_Cuckoo_front_Maiala.JPG 2x\" data-file-width=\"1704\" data-file-height=\"1456\" /></a></div>\n<p class=\"legend\">Coucou oriental</p>\n<table class=\"taxobox_classification\">\n<caption><a href=\"/wiki/Congr%C3%A8s_ornithologique_international\" title=\"Congr\u00e8s ornithologique international\">Classification (COI)</a></caption>\n<tr>\n<th scope=\"row\" style=\"width:8em;\"><a href=\"/wiki/R%C3%A8gne_(biologie)\" title=\"R\u00e8gne (biologie)\">R\u00e8gne</a></th>\n<td><span class=\"normal\"><a href=\"/wiki/Animal\" title=\"Animal\">Animalia</a></span></td>\n</tr>\n<tr>\n<th scope=\"row\" style=\"width:8em;\"><a href=\"/wiki/Embranchement_(biologie)\" title=\"Embranchement (biologie)\">Embranchement</a></th>\n<td><span class=\"normal\"><a href=\"/wiki/Chordata\" title=\"Chordata\">Chordata</a></span></td>\n</tr>\n<tr>\n<th scope=\"row\" style=\"width:8em;\"><a href=\"/wiki/Sous-embranchement\" title=\"Sous-embranchement\">Sous-embr.</a></th>\n<td><span class=\"normal\"><a href=\"/wiki/Vertebrata\" class=\"mw-redirect\" title=\"Vertebrata\">Vertebrata</a></span></td>\n</tr>\n<tr>\n<th scope=\"row\" style=\"width:8em;\"><a href=\"/wiki/Classe_(biologie)\" title=\"Classe (biologie)\">Classe</a></th>\n<td><span class=\"normal\"><a href=\"/wiki/Aves\" class=\"mw-redirect\" title=\"Aves\">Aves</a></span></td>\n</tr>\n<tr>\n<th scope=\"row\" style=\"width:8em;\"><a href=\"/wiki/Ordre_(biologie)\" title=\"Ordre (biologie)\">Ordre</a></th>\n<td><span class=\"normal\"><a href=\"/wiki/Cuculiformes\" title=\"Cuculiformes\">Cuculiformes</a></span></td>\n</tr>\n<tr>\n<th scope=\"row\" style=\"width:8em;\"><a href=\"/wiki/Famille_(biologie)\" title=\"Famille (biologie)\">Famille</a></th>\n<td><span class=\"normal\"><a href=\"/wiki/Cuculidae\" title=\"Cuculidae\">Cuculidae</a></span></td>\n</tr>\n<tr>\n<th scope=\"row\" style=\"width:8em;\"><a href=\"/wiki/Genre_(biologie)\" title=\"Genre (biologie)\">Genre</a></th>\n<td><a href=\"/wiki/Cuculus\" title=\"Cuculus\">Cuculus</a></td>\n</tr>\n</table>\n<p class=\"bloc\"><a href=\"/wiki/Nom_binominal\" title=\"Nom binominal\">Nom binominal</a></p>\n<p class=\"center taxobox_classification\"><b><span style=\"font-style: normal\"><span lang=\"la\"><i>Cuculus optatus</i></span></span></b><br />\n<span class=\"rnormal\"><small><b><a href=\"/wiki/John_Gould\" title=\"John Gould\">Gould</a>, <a href=\"/wiki/1845\" title=\"1845\">1845</a></b></small></span></p>\n</div>\n<p>Le <b>Coucou oriental</b> (<i>Cuculus optatus</i>) est une <a href=\"/wiki/Esp%C3%A8ce\" title=\"Esp\u00e8ce\">esp\u00e8ce</a> de <a href=\"/wiki/Coucou_(oiseau)\" class=\"mw-redirect\" title=\"Coucou (oiseau)\">Coucous</a>, <a href=\"/wiki/Oiseau\" title=\"Oiseau\">oiseaux</a> de la <a href=\"/wiki/Famille_(biologie)\" title=\"Famille (biologie)\">famille</a> des <a href=\"/wiki/Cuculidae\" title=\"Cuculidae\">Cuculidae</a>. Son aire de r\u00e9partition s'\u00e9tend sur la <a href=\"/wiki/Russie\" title=\"Russie\">Russie</a>, le <a href=\"/wiki/Japon\" title=\"Japon\">Japon</a>, la <a href=\"/wiki/Cor%C3%A9e_du_Sud\" title=\"Cor\u00e9e du Sud\">Cor\u00e9e du Sud</a>,la <a href=\"/wiki/Cor%C3%A9e_du_Nord\" title=\"Cor\u00e9e du Nord\">Cor\u00e9e du Nord</a>, <a href=\"/wiki/Ta%C3%AFwan\" title=\"Ta\u00efwan\">Ta\u00efwan</a>, la <a href=\"/wiki/Chine\" title=\"Chine\">Chine</a>, la <a href=\"/wiki/Birmanie\" title=\"Birmanie\">Birmanie</a>, le <a href=\"/wiki/Laos\" title=\"Laos\">Laos</a>, le <a href=\"/wiki/Vi%C3%AAt_Nam\" title=\"Vi\u00eat Nam\">Vi\u00eat Nam</a>, le <a href=\"/wiki/Cambodge\" title=\"Cambodge\">Cambodge</a>, la <a href=\"/wiki/Tha%C3%AFlande\" title=\"Tha\u00eflande\">Tha\u00eflande</a>, la <a href=\"/wiki/Malaisie\" title=\"Malaisie\">Malaisie</a>, <a href=\"/wiki/Brunei\" title=\"Brunei\">Brunei</a>, <a href=\"/wiki/Singapour\" title=\"Singapour\">Singapour</a>, les <a href=\"/wiki/Philippines\" title=\"Philippines\">Philippines</a>, l'<a href=\"/wiki/Indon%C3%A9sie\" title=\"Indon\u00e9sie\">Indon\u00e9sie</a>, la <a href=\"/wiki/Papouasie-Nouvelle-Guin%C3%A9e\" title=\"Papouasie-Nouvelle-Guin\u00e9e\">Papouasie-Nouvelle-Guin\u00e9e</a>, les <a href=\"/wiki/Salomon_(pays)\" title=\"Salomon (pays)\">Salomon</a>, l'<a href=\"/wiki/Australie\" title=\"Australie\">Australie</a> et la <a href=\"/wiki/Micron%C3%A9sie_(pays)\" class=\"mw-redirect\" title=\"Micron\u00e9sie (pays)\">Micron\u00e9sie</a>.</p>\n<p>C'est une esp\u00e8ce <a href=\"/wiki/Monotypique\" class=\"mw-redirect\" title=\"Monotypique\">monotypique</a> (non subdivis\u00e9e en <a href=\"/wiki/Sous-esp%C3%A8ce\" title=\"Sous-esp\u00e8ce\">sous-esp\u00e8ces</a>), consid\u00e9r\u00e9e par certains auteurs comme une sous-esp\u00e8ce de <i><a href=\"/wiki/Cuculus_saturatus\" class=\"mw-redirect\" title=\"Cuculus saturatus\">Cuculus saturatus</a></i>.</p>\n<h2><span class=\"mw-headline\" id=\"Liens_externes\">Liens externes</span><span class=\"mw-editsection\"><span class=\"mw-editsection-bracket\">[</span><a href=\"/w/index.php?title=Coucou_oriental&amp;veaction=edit&amp;section=1\" class=\"mw-editsection-visualeditor\" title=\"Modifier la section : Liens externes\">modifier</a><span class=\"mw-editsection-divider\"> | </span><a href=\"/w/index.php?title=Coucou_oriental&amp;action=edit&amp;section=1\" title=\"Modifier la section : Liens externes\">modifier le code</a><span class=\"mw-editsection-bracket\">]</span></span></h2>\n<div class=\"autres-projets boite-grise boite-a-droite noprint js-interprojets\">\n<p class=\"titre\">Sur les autres projets Wikimedia&#160;:</p>\n<ul class=\"noarchive plainlinks\">\n<li class=\"commons\"><a class=\"external text\" href=\"https://commons.wikimedia.org/wiki/Category:Cuculus_saturatus?uselang=fr\">Coucou oriental</a>, sur <span class=\"project\">Wikimedia Commons</span></li>\n<li class=\"wikispecies\"><a href=\"https://species.wikimedia.org/wiki/Cuculus\" class=\"extiw\" title=\"wikispecies:Cuculus\">Coucou oriental</a>, <span class=\"nowrap\">sur <span class=\"project\">Wikispecies</span></span></li>\n</ul>\n</div>\n<ul>\n<li><span class=\"ouvrage\" id=\"COI\">R\u00e9f\u00e9rence <a href=\"/wiki/Congr%C3%A8s_ornithologique_international\" title=\"Congr\u00e8s ornithologique international\">Congr\u00e8s ornithologique international</a>&#160;: <span class=\"plainlinksneverexpand\"><a rel=\"nofollow\" class=\"external text\" href=\"http://www.worldbirdnames.org/bow/hoatzin/\"><i>Cuculus optatus</i> <small>dans l'ordre</small> Cuculiformes</a></span> <span class=\"indicateur-langue\">(<abbr class=\"abbr\" title=\"Langue&#160;: anglais\">en</abbr>)</span> <small>(consult\u00e9 le <time class=\"nowrap\" datetime=\"2015-05-18\">18 mai 2015</time>)</small></span></li>\n<li><span class=\"ouvrage\" id=\"Zoonomen\">R\u00e9f\u00e9rence <a href=\"/wiki/Alan_P._Peterson\" title=\"Alan P. Peterson\">Alan P. Peterson</a>&#160;: <a rel=\"nofollow\" class=\"external text\" href=\"http://www.zoonomen.net/avtax/cucu.html\"><i>Cuculus optatus</i> dans Cuculiformes</a> <span class=\"indicateur-langue\">(<abbr class=\"abbr\" title=\"Langue&#160;: anglais\">en</abbr>)</span></span></li>\n</ul>\n<ul id=\"bandeau-portail\" class=\"bandeau-portail\">\n<li><span class=\"bandeau-portail-element\"><span class=\"bandeau-portail-icone\"><a href=\"/wiki/Portail:Ornithologie\" title=\"Portail de l'ornithologie\"><img alt=\"Portail de l'ornithologie\" src=\"//upload.wikimedia.org/wikipedia/commons/thumb/e/e2/Pinicola_enucleator.png/30px-Pinicola_enucleator.png\" width=\"30\" height=\"24\" srcset=\"//upload.wikimedia.org/wikipedia/commons/thumb/e/e2/Pinicola_enucleator.png/45px-Pinicola_enucleator.png 1.5x, //upload.wikimedia.org/wikipedia/commons/thumb/e/e2/Pinicola_enucleator.png/60px-Pinicola_enucleator.png 2x\" data-file-width=\"1154\" data-file-height=\"930\" /></a></span> <span class=\"bandeau-portail-texte\"><a href=\"/wiki/Portail:Ornithologie\" title=\"Portail:Ornithologie\">Portail de l'ornithologie</a></span></span></li>\n</ul>\n\n\n<!-- \nNewPP limit report\nParsed by mw2242\nCached time: 20170424090157\nCache expiry: 2592000\nDynamic content: false\nCPU time usage: 0.244 seconds\nReal time usage: 0.332 seconds\nPreprocessor visited node count: 2173/1000000\nPreprocessor generated node count: 0/1500000\nPost\u2010expand include size: 15602/2097152 bytes\nTemplate argument size: 3153/2097152 bytes\nHighest expansion depth: 15/40\nExpensive parser function count: 1/500\nLua time usage: 0.129/10.000 seconds\nLua memory usage: 5.25 MB/50 MB\n-->\n<!--\nTransclusion expansion time report (%,ms,calls,template)\n100.00%  301.982      1 -total\n 34.95%  105.551      1 Mod\u00e8le:\u00c9bauche\n 17.12%   51.707      1 Mod\u00e8le:Portail\n 12.91%   38.986      1 Mod\u00e8le:COI\n 12.77%   38.566      1 Mod\u00e8le:Taxobox_d\u00e9but\n 12.39%   37.416      7 Mod\u00e8le:Taxobox\n 11.70%   35.326      1 Mod\u00e8le:Suivi_des_biographies\n 11.61%   35.050      7 Mod\u00e8le:Infobox_V3/Tableau_Ligne_mixte\n  7.15%   21.597      2 Mod\u00e8le:En\n  6.65%   20.085      2 Mod\u00e8le:Indication_de_langue\n-->\n\n<!-- Saved in parser cache with key frwiki:pcache:idhash:4020068-0!*!0!*!*!4!* and timestamp 20170424090157 and revision id 116268047\n -->\n");
		System.out.println(html_to_text(html));
	}
	
}
