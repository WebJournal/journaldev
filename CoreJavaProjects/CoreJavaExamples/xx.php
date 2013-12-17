<?php
/*
Plugin Name: GetSocial
Plugin URI: http://www.riyaz.net/getsocial
Description: GetSocial adds an intelligent, lightweight, quick to setup floating social media sharing box on your blog posts.
Author: Riyaz
Version: 1.7.4
Author URI: http://www.riyaz.net
License: GPL2
*/

/*  Copyright 2010  Riyaz Sayyad  (email : riyaz@riyaz.net)

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License, version 2, as 
    published by the Free Software Foundation.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program; if not, write to the Free Software
    Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
*/

/* ----------------------------------------------
** Feature Credits **
Name: Custom Write Panel 
URI: http://wefunction.com/2008/10/tutorial-create-custom-write-panels-in-wordpress 
Description: Allows custom fields to be added to the WordPress Post Page 
Version: 1.0 
Author: Spencer 
Author URI: http://wefunction.com 

Name: Farbtastic: jQuery color picker plug-in 
URI: http://acko.net/dev/farbtastic 
Description: Adds color picker widgets into a page
Version: 1.2
Author: Steven Wittens 
Author URI: http://acko.net/dev/farbtastic
----------------------------------------------*/  
?>
<?php
//enable the jQuery library in Wordpress
function getsocial_init() {
  wp_enqueue_script('jquery');
  wp_enqueue_style( 'farbtastic' );
  wp_enqueue_script( 'farbtastic' );
}
add_action('init', 'getsocial_init');

?>
<?php
function add_getsocial_styles(){
if (showbox()){
$back_color = trim(get_option('getsocial_background_color', '#EAEAF4'),"#");
$border_color = trim(get_option('getsocial_border_color', '#D9D9ED'),"#");
$strip_color = get_option('getsocial_background_image', 'dark');
$preload_hide = get_option('getsocial_preload_hide', 'no');
$bar_width = get_option('getsocial_bar_width', 73);
$rounded_corners = get_option('getsocial_rounded_corners', "yes");
$strip_align = get_option('getsocial_strip_align', 'right');
?>
<link rel="stylesheet" type="text/css" href="<?php echo WP_PLUGIN_URL . '/getsocial/lib/getsocialstyles.php?color=' . $back_color . '&border=' . $border_color . '&w=' . $bar_width . '&strip=' . $strip_color . '&prehide=' . $preload_hide . '&rc=' . $rounded_corners . '&stralign=' . $strip_align; ?>" />
<?php
}
}
add_action('wp_head','add_getsocial_styles');
?>
<?php
function get_getsocial_scripts(){
$getsocial_js = "";
if (showbox()){
	$getsocial_js = '<script type="text/javascript">'
					.'var $opt_initial_top = '. get_option('getsocial_initial_top') .';'
					.'var $opt_scrolled_top = '. get_option('getsocial_scrolled_top') .';'
					.'var $opt_browser_width = '. get_option('getsocial_browser_width') .';'
					.'var $opt_box_left = '. get_option('getsocial_left') .';'
					.'</script>'
					.'<script type="text/javascript" src="'. WP_PLUGIN_URL . '/getsocial/lib/getsocial.js'.'"></script>';
	}
	return $getsocial_js;
}
?>
<?php 
function getsocial_admin_scripts() {
	if ( (is_admin() && $_GET['page'] == 'getsocial/getsocial.php') ) {
	
		wp_deregister_script('jquery');
		wp_register_script('jquery', 'http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js');
		wp_enqueue_script('jquery');
		
		wp_register_script('jquery-ui', 'https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.13/jquery-ui.min.js');
		wp_enqueue_script('jquery-ui');
		
		wp_register_script('jquery-qtip', plugins_url() . '/getsocial/lib/jquery.qtip.pack.js' );
		wp_enqueue_script('jquery-qtip');
	}
}
add_action('admin_enqueue_scripts', 'getsocial_admin_scripts');
?>
<?php 
function getsocial_admin_style() {
	if ( (is_admin() && $_GET['page'] == 'getsocial/getsocial.php') ) { 
	?>
		<link rel="stylesheet" type="text/css" href="<?php echo plugins_url() . '/getsocial/lib/adminstyles.css'; ?>" />
	<?php
	}
}
add_action('wp_print_scripts', 'getsocial_admin_style');
?>
<?php
function add_getsocial_div($content) {
	global $post;
	global $gs_url, $gs_image_url, $gs_title;
	if (showbox()){
		$gs_image_url = "";
		$gs_title = get_the_title($post->ID);
		$gs_url = get_permalink($post->ID);
		
		$full_image_url = getsocial_get_images($post->ID);
		if ($full_image_url) { $gs_image_url =  $full_image_url[0][0]; }

		if ( function_exists( 'has_post_thumbnail' ) ) {
			if (has_post_thumbnail( $post->ID ) ) {
				$full_image_url = wp_get_attachment_image_src( get_post_thumbnail_id( $post->ID ), 'full');
				$gs_image_url =  $full_image_url[0];
			}
		}

		$content = '<div id="getsocialmain">' . $content . '</div><!-- #getsocialmain -->'; 
	}
	return $content;
}
?>
<?php
function getsocial_get_images($post_id, $size = 'full') {

	$images = get_children( array('post_parent' => $post_id, 'post_status' => 'inherit', 'post_type' => 'attachment', 'post_mime_type' => 'image', 'order' => 'ASC', 'orderby' => 'menu_order ID') );
	$results = array();

	if ($images) {
		foreach ($images as $image) {
			$results[] = wp_get_attachment_image_src($image->ID, $size);
		}
	}
	return $results;
}
?>
<?php
function add_getsocial_scripts ( ) { 
	echo get_getsocial_scripts();
}

function add_getsocial_box ( ) { 
	echo get_getsocial_box();
}

if (get_option('getsocial_scripts_in_footer') == "true") {
	add_filter('the_content', 'add_getsocial_div', 30);
	add_action('wp_footer','add_getsocial_scripts');
	add_action('wp_footer','add_getsocial_box');
}
else{
	add_action('wp_head','add_getsocial_scripts');
	add_action('wp_head','add_getsocial_box');
	add_filter('the_content', 'add_getsocial_div', 30);
}
?>
<?php
function showbox(){
global $post;  
$post_type = get_post_type( );
$hide_box_value = get_post_meta($post->ID, 'getsocial_hide_value', true);  
if (is_single() && ( $post_type == 'post' ) && get_option('getsocial_show_on_posts') == "true" && $hide_box_value != "true" ) return true;
elseif (is_page() && get_option('getsocial_show_on_pages') == "true" && $hide_box_value != "true" ) return true;
elseif ( ( is_home() || is_front_page() ) && get_option('getsocial_show_on_homepage') == "true" ) return true;
else return false;
}
?>
<?php
function get_getsocial_box(){
$getsocial_html = "";
/*global $post;*/
/*$permalink = get_permalink($post->ID);*/
if (showbox()){
	?>
	<?php $getsocial_html = '<div class="getsocial">'; ?>
	<?php
		$order = get_option('getsocial_order','rtw,rbf,rfb,rgp,rsu,rdg,rli,rpi,rab');
		$order = trim ($order, ',');
		$rows = explode (",",$order);
		foreach ($rows as $row) {
			$getsocial_html .= getsocial_button_code_get( $row, 'display' );
		}
	?>
	<?php if (get_option('getsocial_linkluv') == "true") {
	$getsocial_html .= '<div class="sharebutton sharefooter"><a href="http://www.riyaz.net/getsocial" title="GetSocial Plugin by riyaz.net">GetSocial</a></div>';
	} ?>
	<?php $getsocial_html .= '</div>'; ?>
	<?php
	}
	return $getsocial_html;
}
?>
<?php
// create custom plugin settings menu
add_action('admin_menu', 'getsocial_create_menu');

function getsocial_create_menu() {
	//create new top-level menu
	add_menu_page('GetSocial Settings', 'GetSocial', 'administrator', __FILE__, 'getsocial_settings_page',plugins_url('/images/riyaznet.ico', __FILE__));

	//call register settings function
	add_action( 'admin_init', 'register_getsocial_settings' );
}

function register_getsocial_settings() {
	//register the settings
	register_setting( 'getsocial-settings-group', 'getsocial_initial_top', 'intval' );
	register_setting( 'getsocial-settings-group', 'getsocial_scrolled_top' , 'intval' );
	register_setting( 'getsocial-settings-group', 'getsocial_left' , 'intval' );
	register_setting( 'getsocial-settings-group', 'getsocial_browser_width' , 'intval' );
	register_setting( 'getsocial-settings-group', 'getsocial_bar_width' , 'intval' );
	register_setting( 'getsocial-settings-group', 'getsocial_show_on_posts' );
	register_setting( 'getsocial-settings-group', 'getsocial_show_on_pages' );
	register_setting( 'getsocial-settings-group', 'getsocial_show_on_homepage' );
	register_setting( 'getsocial-settings-group', 'getsocial_background_color' );
	register_setting( 'getsocial-settings-group', 'getsocial_border_color' );
	register_setting( 'getsocial-settings-group', 'getsocial_background_image' );
	register_setting( 'getsocial-settings-group', 'getsocial_rounded_corners' );
	register_setting( 'getsocial-settings-group', 'getsocial_strip_align' );
	register_setting( 'getsocial-settings-group', 'getsocial_preload_hide' );
	register_setting( 'getsocial-settings-group', 'getsocial_order' );
	register_setting( 'getsocial-settings-group', 'getsocial_twitter' );
	register_setting( 'getsocial-settings-group', 'getsocial_buffer' );
	register_setting( 'getsocial-settings-group', 'getsocial_twitter_username' );
	register_setting( 'getsocial-settings-group', 'getsocial_facebook' );
	register_setting( 'getsocial-settings-group', 'getsocial_googleplusone' );
	register_setting( 'getsocial-settings-group', 'getsocial_stumbleupon' );
	register_setting( 'getsocial-settings-group', 'getsocial_digg' );
	register_setting( 'getsocial-settings-group', 'getsocial_linkedin' );
	register_setting( 'getsocial-settings-group', 'getsocial_pinterest' );
	/* register_setting( 'getsocial-settings-group', 'getsocial_blendit' ); */
	register_setting( 'getsocial-settings-group', 'getsocial_additional' );
	register_setting( 'getsocial-settings-group', 'getsocial_linkluv' );
	register_setting( 'getsocial-settings-group', 'getsocial_scripts_in_footer' );
}

function getsocial_settings_page() {
?>
<div class="wrap gswrap">
<h2 class="gs-branding">GetSocial Settings</h2>
<script>
	$(document).ready(function() {
	
		var shared = {
			position: {
				my: 'top left', 
				at: 'bottom right'
			},
			show: {
				event: 'mouseenter',
				solo: true
			},
			hide: 'unfocus',
			style: {
				classes: 'ui-tooltip-smblue ui-tooltip-shadow ui-tooltip-rounded'
			}
		};
		
		$( "#check-display" ).buttonset();
		$( "#radio-bi" ).buttonset();
		$( "#radio-ph" ).buttonset();
		$( "#radio-sta" ).buttonset();
		$( "#radio-rc" ).buttonset();
		$( "#radio-tc" ).buttonset();
		$( "#radio-bc" ).buttonset();
		$( "#radio-fc" ).buttonset();
		$( "#radio-gc" ).buttonset();
		$( "#radio-sc" ).buttonset();
		$( "#radio-dc" ).buttonset();
		$( "#radio-lc" ).buttonset();
		$( "#radio-pc" ).buttonset();
		$( "#radio-sutl" ).buttonset();
		$( "#radio-lsif" ).buttonset();
		$( "input:submit, a, button", ".getsocial-button-element" ).button();
		
		$( ".ioft" ).qtip( $.extend({}, shared, {
		content: '<strong>Initial Offset from top:</strong><br><br>Distance in pixels from the top of the window when the page is first loaded.<br><br>Default: 200px'
		}));
		
		$( ".oftas" ).qtip( $.extend({}, shared, {
		content: '<strong>Offset from top after scrolling:</strong><br><br>Distance in pixels from the top of the window after the user has scrolled down considerably.<br><br>Default: 20px'
		}));
		
		$( ".ofl" ).qtip( $.extend({}, shared, {
		content: '<strong>Offset from left:</strong><br><br>Adjust this value to move the GetSocial box horizontally. Higher value moves it farther to the left, while lower value moves it to the right.<br><br>Default: 80px'
		}));
		
		$( ".brw" ).qtip( $.extend({}, shared, {
		content: '<strong>Browser Width:</strong><br><br>This is the minimum width of the browser window to allow full display of GetSocial box without hiding to the left. When the browser window is resized to a value smaller than this, GetSocial box partially hides to the left. Hovering over it will allow full display. This feature is also useful for users using screens with lower resolution like 800x600px. <br><br>Adjust this value according to the maximum width of your theme\'s used up area. For example, if your theme\'s used up width is 1000px, you may set the browser width to 1140px (1000 + 140) or slighly higher.)<br><br>Default: 1140px'
		}));
		
		$( ".gsw" ).qtip( $.extend({}, shared, {
		content: '<strong>Width of the GetSocial bar:</strong><br><br>Here you can specify the width of the GetSocial bar. This could be useful when your default langauage is not English and the Like buttons are wider.<br><br>Default: 73px'
		}));
		
		$( ".dopp" ).qtip( $.extend({}, shared, {
		content: '<strong>Display on:</strong><br><br>Choose whether to display GetSocial bar on posts, pages, and/or homepage. This setting can be overridden on individual posts/pages by changing the GetSocial Settings on the Edit Page/Post screen.'
		}));
		
		$( ".backcolor" ).qtip( $.extend({}, shared, {
		content: '<strong>Background Color:</strong><br><br>Background Color of the GetSocial box. Click on the field to display the color picker. Click again to close it.<br><br>Default: #EAEAF4'
		}));
		
		$( ".stfc" ).qtip( $.extend({}, shared, {
		content: '<strong>Share Title Font Color:</strong><br><br>Font color of the title strip. Choose None to hide the share title strip.<br><br>Default: Dark'
		}));
		
		$( ".sta" ).qtip( $.extend({}, shared, {
		content: '<strong>Share Title Alignment:</strong><br><br>Aligns Share Title to the left or right edge of the GetSocial bar.<br><br>Default: Right'
		}));
		
		$( ".bordercolor" ).qtip( $.extend({}, shared, {
		content: '<strong>Border Color:</strong><br><br>Border color of the GetSocial box. Click on the field to display the color picker. Click again to close it.<br><br>Default: #D9D9ED'
		}));
		
		$( ".roundedcorners" ).qtip( $.extend({}, shared, {
		content: '<strong>Show Rounded Corners:</strong><br><br>Select Yes if you would like the GetSocial bar to have rounded corners.'
		}));
		
		$( ".prehide" ).qtip( $.extend({}, shared, {
		content: '<strong>Hide Initially:</strong><br><br>Hides the GetSocial bar initially until the page loads completely.<br><br>Default: No'
		}));
		
		$( ".ab" ).qtip( $.extend({}, shared, {
		content: '<strong>Additional buttons:</strong><br><br>To show additional buttons, simply add HTML code for the buttons here.<br>Enclose the code for each button within <code>&lt;div class="sharebutton"&gt;</code> and <code>&lt;/div&gt;</code> tags.<br><br>For example:<br><code>&lt;div class="sharebutton"&gt;<br>&nbsp;&nbsp;&lt;!-- Code for additional button 1 --&gt;<br>&lt;/div&gt;<br>&lt;div class="sharebutton"&gt;<br>&nbsp;&nbsp;&lt;!-- Code for additional button 2 --&gt;<br>&lt;/div&gt;</code><br><br>Learn how to quickly <a href="http://www.riyaz.net/blog/customize-getsocial-with-css3/wordpress/1677/" target="_blank">add awesome social sharing buttons to GetSocial</a>.'
		}));
		
		$( ".sutl" ).qtip( $.extend({}, shared, {
		content: '<strong>Support us through Linkluv:</strong><br><br>Shows a tiny unobtrusive link to <a href="http://www.riyaz.net/getsocial/" target="_blank">GetSocial homepage</a>. Thank you for your support.'
		}));
		
		$( ".lsif" ).qtip( $.extend({}, shared, {
		content: '<strong>Load scripts in Footer:</strong><br><br>Loads scripts in footer by default. Uncheck this only if the GetSocial box does not appear at all.'
		}));
		
		$( ".gstb" ).qtip( $.extend({}, shared, {
		content: 'Displays Tweet button from Twitter.'
		}));
		
		$( ".gsbb" ).qtip( $.extend({}, shared, {
		content: 'Displays Buffer button.'
		}));
		
		$( ".gstu" ).qtip( $.extend({}, shared, {
		content: 'Specify the Twitter username to be used for retweeting.'
		}));
		
		$( ".gsfb" ).qtip( $.extend({}, shared, {
		content: 'Displays Facebook Like button with or without Send button.'
		}));
		
		$( ".gsgb" ).qtip( $.extend({}, shared, {
		content: 'Displays Google +1 button.'
		}));
		
		$( ".gssb" ).qtip( $.extend({}, shared, {
		content: 'Displays StumbleUpon Submit button.'
		}));
		
		$( ".gsdb" ).qtip( $.extend({}, shared, {
		content: 'Displays Submit to Digg button.'
		}));
		
		$( ".gslb" ).qtip( $.extend({}, shared, {
		content: 'Displays LinkedIn Share button'
		}));
		
		$( ".gspb" ).qtip( $.extend({}, shared, {
		content: 'Displays Pin it button from Pinterest'
		}));
	});
</script>
<script>
	$(function() {
		$( "#sortable" ).sortable({
			cursor: "move",
			update: function(event, ui) {
				var order = $(this).sortable('toArray').toString();
				document.forms["gsopt"]["getsocial_order"].value = order;
			}
		});
		$( "#sortable" ).disableSelection();
	});
</script>
<?php
global $wp_query;
?>
<form method="post" action="options.php" name="gsopt">
    <?php settings_fields( 'getsocial-settings-group' ); ?>
	<div class="getsocial-button-element">
	<button><?php _e('Save Changes') ?></button>
	</div>
	<div id="gs-left">
	<h3>Positioning and Size</h3>

    <table class="form-table gstleft">
        <tr valign="top">
        <th scope="row">Initial Offset from top<span class="ioft getsocial-help"><img src="<?php echo plugins_url();?>/getsocial/images/help.png"></span></th>
        <td><input type="text" name="getsocial_initial_top" value="<?php echo get_option('getsocial_initial_top', 200); ?>" style="width: 50px;" /> px</td>
        </tr>

        <tr valign="top">
        <th scope="row">Offset from left<span class="ofl getsocial-help"><img src="<?php echo plugins_url();?>/getsocial/images/help.png"></span></th>
        <td><input type="text" name="getsocial_left" value="<?php echo get_option('getsocial_left', 80); ?>" style="width: 50px;"/> px</td>
        </tr>
		
		<tr valign="top">
        <th scope="row">Browser Width<span class="brw getsocial-help"><img src="<?php echo plugins_url();?>/getsocial/images/help.png"></span></th>
        <td><input type="text" name="getsocial_browser_width" value="<?php echo get_option('getsocial_browser_width', 1140); ?>" style="width: 50px;"/> px</td>
        </tr>
		
		<tr valign="top">
        <th scope="row">Offset from top after scrolling<span class="oftas getsocial-help"><img src="<?php echo plugins_url();?>/getsocial/images/help.png"></span></th>
        <td><input type="text" name="getsocial_scrolled_top" value="<?php echo get_option('getsocial_scrolled_top', 20); ?>" style="width: 50px;"/>px</td>
        </tr>
		
		<tr valign="top">
        <th scope="row">Width of the GetSocial bar<span class="gsw getsocial-help"><img src="<?php echo plugins_url();?>/getsocial/images/help.png"></span></th>
        <td><input type="text" name="getsocial_bar_width" value="<?php echo get_option('getsocial_bar_width', 73); ?>" style="width: 50px;"/>px</td>
        </tr>
    </table>
<h3>Display Options and Colors</h3>
	<table class="form-table gstleft">
        <tr valign="top">
        <th scope="row">Display on<span class="dopp getsocial-help"><img src="<?php echo plugins_url();?>/getsocial/images/help.png"></span></th>
        <td>
			<div id="check-display">
			<input type="checkbox" name="getsocial_show_on_posts" id="getsocial_show_on_posts" value="true" <?php if (get_option('getsocial_show_on_posts', true) == "true") { _e('checked="checked"', "getsocial_show_on_posts"); }?> /><label for="getsocial_show_on_posts">Posts</label>
			<input type="checkbox" name="getsocial_show_on_pages" id="getsocial_show_on_pages" value="true" <?php if (get_option('getsocial_show_on_pages', false) == "true") { _e('checked="checked"', "getsocial_show_on_pages"); }?> /><label for="getsocial_show_on_pages">Pages</label>
			<input type="checkbox" name="getsocial_show_on_homepage" id="getsocial_show_on_homepage" value="true" <?php if (get_option('getsocial_show_on_homepage', false) == "true") { _e('checked="checked"', "getsocial_show_on_homepage"); }?> /><label for="getsocial_show_on_homepage">Home</label>
			</div>
		</td>
        </tr>
		
		<tr valign="top">
		<th scope="row">Background Color<span class="backcolor getsocial-help"><img src="<?php echo plugins_url();?>/getsocial/images/help.png"></span></th>
		<td><input type="text" id ="bkcolor" name="getsocial_background_color" value="<?php echo get_option('getsocial_background_color', '#EAEAF4'); ?>" style="width: 70px;" />
		<div id="bkcolorpicker"></div>
		</td>
		</tr>
			<script type="text/javascript">
			  jQuery(document).ready(function() {
				jQuery('#bkcolorpicker').hide();
				jQuery('#bkcolorpicker').farbtastic("#bkcolor");
				jQuery("#bkcolor").click(function(){jQuery('#bkcolorpicker').slideToggle()});
			  });
			</script>		
		
		<tr valign="top">
        <th scope="row">Share Title Font Color<span class="stfc getsocial-help"><img src="<?php echo plugins_url();?>/getsocial/images/help.png"></span></th>
        <td>
			<div id="radio-bi">
				<input type="radio" name="getsocial_background_image" id="gs-bi-dark" value="dark" <?php if (get_option('getsocial_background_image', 'dark') == "dark") { echo 'checked'; }?> /><label for="gs-bi-dark">Dark</label>
				<input type="radio" name="getsocial_background_image" id="gs-bi-light" value="light" <?php if (get_option('getsocial_background_image', 'dark') == "light") { echo 'checked'; }?> /><label for="gs-bi-light">Light</label>
				<input type="radio" name="getsocial_background_image" id="gs-bi-hide" value="hide" <?php if (get_option('getsocial_background_image', 'dark') == "hide") { echo 'checked'; }?> /><label for="gs-bi-hide">None</label>
			</div>
		</td>
        </tr>
        
		<tr valign="top">
        <th scope="row">Share Title Alignment<span class="sta getsocial-help"><img src="<?php echo plugins_url();?>/getsocial/images/help.png"></span></th>
        <td>
			<div id="radio-sta">
				<input type="radio" name="getsocial_strip_align" id="gs-sta-left" value="left" <?php if (get_option('getsocial_strip_align', 'right') == "left") { echo 'checked'; }?> /><label for="gs-sta-left">Left</label>
				<input type="radio" name="getsocial_strip_align" id="gs-sta-right" value="right" <?php if (get_option('getsocial_strip_align', 'right') == "right") { echo 'checked'; }?> /><label for="gs-sta-right">Right</label>
			</div>
		</td>
        </tr>
		
		<tr valign="top">
		<th scope="row">Border Color<span class="bordercolor getsocial-help"><img src="<?php echo plugins_url();?>/getsocial/images/help.png"></span></th>
        <td><input type="text" id="bordercolor" name="getsocial_border_color" value="<?php echo get_option('getsocial_border_color', '#D9D9ED'); ?>" style="width: 70px;" />
		<div id="bordercolorpicker"></div>
		</td>
        </tr>
		
		<script type="text/javascript">
		  jQuery(document).ready(function() {
			jQuery('#bordercolorpicker').hide();
			jQuery('#bordercolorpicker').farbtastic("#bordercolor");
			jQuery("#bordercolor").click(function(){jQuery('#bordercolorpicker').slideToggle()});
		  });
		</script>
        
		<tr valign="top">
        <th scope="row">Hide Initially<span class="prehide getsocial-help"><img src="<?php echo plugins_url();?>/getsocial/images/help.png"></span></th>
        <td>
			<div id="radio-ph">
				<input type="radio" name="getsocial_preload_hide" id="gs-ph-yes" value="yes" <?php if (get_option('getsocial_preload_hide', 'no') == "yes") { echo 'checked'; }?> /><label for="gs-ph-yes">Yes</label>
				<input type="radio" name="getsocial_preload_hide" id="gs-ph-no" value="no" <?php if (get_option('getsocial_preload_hide', 'no') == "no") { echo 'checked'; }?> /><label for="gs-ph-no">No</label>
			</div>
		</td>
        </tr>
		
		<tr valign="top">
        <th scope="row">Show Rounded Corners<span class="roundedcorners getsocial-help"><img src="<?php echo plugins_url();?>/getsocial/images/help.png"></span></th>
        <td>
			<div id="radio-rc">
				<input type="radio" name="getsocial_rounded_corners" id="gs-rc-yes" value="yes" <?php if (get_option('getsocial_rounded_corners', 'yes') == "yes") { echo 'checked'; }?> /><label for="gs-rc-yes">Yes</label>
				<input type="radio" name="getsocial_rounded_corners" id="gs-rc-no" value="no" <?php if (get_option('getsocial_rounded_corners', 'yes') == "no") { echo 'checked'; }?> /><label for="gs-rc-no">No</label>
			</div>
		</td>
        </tr>
    </table>
<h3>Advanced Options</h3>
	<table class="form-table gstleft">
        <tr valign="top">
        <th scope="row">Load scripts in Footer<span class="lsif getsocial-help"><img src="<?php echo plugins_url();?>/getsocial/images/help.png"></span></th>
        <td><div id="radio-lsif">
			<input type="radio" name="getsocial_scripts_in_footer" id="gssfyes" value="true" <?php if (get_option('getsocial_scripts_in_footer', true) == "true") { _e('checked="checked"', "getsocial_scripts_in_footer"); }?> /><label for="gssfyes">Yes</label>
			<input type="radio" name="getsocial_scripts_in_footer" id="gssfno" value="false" <?php if (get_option('getsocial_scripts_in_footer', true) == "false") { _e('checked="checked"', "getsocial_scripts_in_footer"); }?> /><label for="gssfno">No</label>
		</div></td>
        </tr>
    </table>	
	</div>
	<div id="gs-middle">
<h3>Social Media Buttons</h3>
	<ul>
	<li>
		<div class="sortth">Twitter Username<span class="gstu getsocial-help"><img src="<?php echo plugins_url();?>/getsocial/images/help.png"></span></div>
		<div class="sorttd"><input type="text" name="getsocial_twitter_username" value="<?php echo get_option('getsocial_twitter_username'); ?>" /></div>
	</li>
	<li>
		<div class="sorttd"><input type="hidden" name="getsocial_order" id="getsocial_order" value="<?php echo get_option('getsocial_order','rtw,rbf,rfb,rgp,rsu,rdg,rli,rpi,rab'); ?>" /></div>
	</li>
	</ul>
	<input type="hidden" name="order" id="order" value=""/>
    <ul id="sortable" class="gstmiddle">
		<div class="dragtitle">Simply drag and drop the boxes below to re-order the buttons on GetSocial bar.</div>
		<?php
			$order = get_option('getsocial_order','rtw,rbf,rfb,rgp,rsu,rdg,rli,rpi,rab');
			$order = trim ($order, ',');
			$rows = explode (",",$order);
			foreach ($rows as $row) {
				getsocial_button_code_get( $row, 'options' );
			}
		?>
	</ul>
	<ul>
	<h3 style="float:left; clear:both;">Show Your Support</h3>
		<li>
			<div class="sortth">Share some Linkluv<span class="sutl getsocial-help"><img src="<?php echo plugins_url();?>/getsocial/images/help.png"></span></div>
			<div class="sorttd"><div id="radio-sutl">
				<input type="radio" name="getsocial_linkluv" id="gsllyes" value="true" <?php if (get_option('getsocial_linkluv', true) == "true") { _e('checked="checked"', "getsocial_linkluv"); }?> /><label for="gsllyes">Sure, I don't mind</label>
				<input type="radio" name="getsocial_linkluv" id="gsllno" value="false" <?php if (get_option('getsocial_linkluv', true) == "false") { _e('checked="checked"', "getsocial_linkluv"); }?> /><label for="gsllno">No, Please hide it</label>
			</div></div>
		</li>
	</ul>
	</div>
    <div id="gs-right">
		<div style="margin-left:5px;"><script type="text/javascript" src="http://forms.aweber.com/form/50/1867458150.js"></script></div>	
	</div>
    <div class="getsocial-button-element">
		<button><?php _e('Save Changes') ?></button>
	</div>
	<div class="clear"></div>
	<div style="padding-top:20px;color:#808080;">For Help, Support, Bugs, Feedback, Suggestions, Feature requests, please visit <a href="http://www.riyaz.net/getsocial/" style="text-decoration:none;" target="_blank">GetSocial Homepage</a>.</div>
</form>
</div>
<?php } ?>
<?php 
$getsocial_meta_boxes =  
array(  
"getsocial_hide" => array(  
"name" => "getsocial_hide",  
"std" => "",  
"title" => "Hide GetSocial box on this post/page",  
"description" => "Hide GetSocial box on this post/page")  
);  

function getsocial_meta_boxes() {  
	global $post, $getsocial_meta_boxes;  
	  
	foreach($getsocial_meta_boxes as $meta_box) {  
	$meta_box_value = get_post_meta($post->ID, $meta_box['name'].'_value', true);  
	  
	if($meta_box_value == "")  
	$meta_box_value = $meta_box['std'];  
	  
	echo'<input type="hidden" name="'.$meta_box['name'].'_noncename" id="'.$meta_box['name'].'_noncename" value="'.wp_create_nonce( plugin_basename(__FILE__) ).'" />';  
	  
	echo''.$meta_box['title'].' ';  

	if($meta_box_value == true)   
		echo'<input type="checkbox" name="'.$meta_box['name'].'_value" value="true" checked="checked" /><br />';  
	else
		echo'<input type="checkbox" name="'.$meta_box['name'].'_value" value="true" /><br />';  
	} 
}
function create_getsocial_meta_box() {  
global $theme_name;  
if ( function_exists('add_meta_box') ) {  
	add_meta_box( 'new-meta-boxes', 'GetSocial Settings', 'getsocial_meta_boxes', 'page', 'normal', 'high' );  
	add_meta_box( 'new-meta-boxes', 'GetSocial Settings', 'getsocial_meta_boxes', 'post', 'normal', 'high' );  
	}  
}  

function save_getsocial_postdata( $post_id ) {  
global $post, $getsocial_meta_boxes;  
  
foreach($getsocial_meta_boxes as $meta_box) {  
// Verify  
if ( !wp_verify_nonce( $_POST[$meta_box['name'].'_noncename'], plugin_basename(__FILE__) )) {  
return $post_id;  
}  
  
if ( 'page' == $_POST['post_type'] ) {  
if ( !current_user_can( 'edit_page', $post_id ))  
return $post_id;  
} else {  
if ( !current_user_can( 'edit_post', $post_id ))  
return $post_id;  
}  
  
$data = $_POST[$meta_box['name'].'_value'];  
  
if(get_post_meta($post_id, $meta_box['name'].'_value') == "")  
add_post_meta($post_id, $meta_box['name'].'_value', $data, true);  
elseif($data != get_post_meta($post_id, $meta_box['name'].'_value', true))  
update_post_meta($post_id, $meta_box['name'].'_value', $data);  
elseif($data == "")  
delete_post_meta($post_id, $meta_box['name'].'_value', get_post_meta($post_id, $meta_box['name'].'_value', true));  
}  
}  
add_action('admin_menu', 'create_getsocial_meta_box');  
add_action('save_post', 'save_getsocial_postdata');   
?>
<?php
function gs_get_page_image_url( $url ) {
	$result = 'http://s.wordpress.com/mshots/v1/' . urlencode($url) . '?w=600';
	return $result;
}

?>
<?php
function gs_get_page_url() {
    $pageURL = 'http';     
    if ($_SERVER["HTTPS"] == "on") {
        $pageURL .= "s";    
	}     
	$pageURL .= "://";     
		if ($_SERVER["SERVER_PORT"] != "80") {
$pageURL .= $_SERVER["SERVER_NAME"].":".$_SERVER["SERVER_PORT"].$_SERVER["REQUEST_URI"];
     	     }
	else {
	         $pageURL .= $_SERVER["SERVER_NAME"].$_SERVER["REQUEST_URI"];
	     } 
	return $pageURL;
}
?>
<?php
function getsocial_button_code_get($service, $context = 'display') {
	$html = '';
	global $gs_url,$gs_title,$gs_image_url;
	if ( empty($gs_url) || is_home() || is_front_page() ) {
		$permalink = gs_get_page_url();
	} else {
		$permalink = $gs_url;
	}

	if ( empty($gs_image_url) || is_home() || is_front_page() ) {
		$gs_image_url= gs_get_page_image_url( $permalink );
	}
	
	if ( empty( $gs_title ) || is_home() || is_front_page() ) { 
		$gs_title = get_bloginfo('name');
	}
	
	switch ( $service ) {
		case 'rtw':
			if ($context == 'display') {
				if (get_option('getsocial_twitter') != "hide") {
					$html = '<div class="sharebutton">'
							.'<a href="http://twitter.com/share" class="twitter-share-button" data-count="' . get_option('getsocial_twitter', 'vertical') . '" data-via="'. get_option('getsocial_twitter_username') .'" data-related="'. get_option('getsocial_twitter_username') .'">Tweet</a>'
							.'<script type="text/javascript" src="http://platform.twitter.com/widgets.js"></script></div>';
				}
			}
			if ($context == 'options') { ?>
				<li class="ui-state-default" id="rtw">
					<div class="sortth">Twitter Tweet Button<span class="gstb getsocial-help"><img src="<?php echo plugins_url();?>/getsocial/images/help.png"></span></div>
					<div class="sorttd"><div id="radio-tc">
						<input type="radio" name="getsocial_twitter" id="gstver" value="vertical" <?php if (get_option('getsocial_twitter', "vertical") == "vertical") { _e('checked="checked"', "getsocial_twitter"); }?> /><label for="gstver">Button + Count</label>
						<input type="radio" name="getsocial_twitter" id="gstnc" value="none" <?php if (get_option('getsocial_twitter', "vertical") == "none") { _e('checked="checked"', "getsocial_twitter"); }?> /><label for="gstnc">No Count</label>
						<input type="radio" name="getsocial_twitter" id="gsthide" value="hide" <?php if (get_option('getsocial_twitter', "vertical") == "hide") { _e('checked="checked"', "getsocial_twitter"); }?> /><label for="gsthide">Hide</label>
					</div></div>
				</li>
			<?php }
			break;
		case 'rbf':
			if ($context == 'display') {
				if (get_option('getsocial_buffer') != "hide") {
					$html = '<div class="sharebutton">'
							.'<a href="http://bufferapp.com/add" class="buffer-add-button" data-count="' . get_option('getsocial_buffer', 'vertical') . '" data-via="'. get_option('getsocial_twitter_username') .'" data-related="'. get_option('getsocial_twitter_username') .'">Buffer</a>'
							.'<script type="text/javascript" src="http://static.bufferapp.com/js/button.js"></script></div>';
				}
			}
			if ($context == 'options') { ?>
				<li class="ui-state-default" id="rbf">
					<div class="sortth">Buffer Button<span class="gsbb getsocial-help"><img src="<?php echo plugins_url();?>/getsocial/images/help.png"></span></div>
					<div class="sorttd"><div id="radio-bc">
						<input type="radio" name="getsocial_buffer" id="gsbver" value="vertical" <?php if (get_option('getsocial_buffer', "vertical") == "vertical") { _e('checked="checked"', "getsocial_buffer"); }?> /><label for="gsbver">Button + Count</label>
						<input type="radio" name="getsocial_buffer" id="gsbnc" value="none" <?php if (get_option('getsocial_buffer', "vertical") == "none") { _e('checked="checked"', "getsocial_buffer"); }?> /><label for="gsbnc">No Count</label>
						<input type="radio" name="getsocial_buffer" id="gsbhide" value="hide" <?php if (get_option('getsocial_buffer', "vertical") == "hide") { _e('checked="checked"', "getsocial_buffer"); }?> /><label for="gsbhide">Hide</label>
					</div></div>
				</li>
			<?php }
			break;
		case 'rfb':
			if ($context == 'display') {
				if (get_option('getsocial_facebook') != "hide") {
					$bar_width = get_option('getsocial_bar_width', 73) - 10;
					$fb_send = "false";
					if (get_option('getsocial_facebook') == "box_count_send") $fb_send = "true";
					$html = '<div class="sharebutton">'
							.'<div id="fb-root"></div>'
							.'<script>(function(d, s, id) {'
							.'  var js, fjs = d.getElementsByTagName(s)[0];'
							.'  if (d.getElementById(id)) return;'
							.'  js = d.createElement(s); js.id = id;'
							.'  js.src = "//connect.facebook.net/en_US/all.js#xfbml=1";'
							.'  fjs.parentNode.insertBefore(js, fjs);'
							."}(document, 'script', 'facebook-jssdk'));</script>"
							.'<div class="fb-like" data-href="' . urlencode($permalink) . '" data-send="' . $fb_send . '" data-layout="box_count" data-width="'. $bar_width .'" data-show-faces="false"></div>'
							.'</div>';
				}
			}
			if ($context == 'options') { ?>
				<li class="ui-state-default" id="rfb">
					<div class="sortth">Facebook Like Button<span class="gsfb getsocial-help"><img src="<?php echo plugins_url();?>/getsocial/images/help.png"></span></div>
					<div class="sorttd"><div id="radio-fc">
						<input type="radio" name="getsocial_facebook" id="gsfver" value="box_count" <?php if (get_option('getsocial_facebook', "box_count_send") == "box_count") { _e('checked="checked"', "getsocial_facebook"); }?> /><label for="gsfver">Like Button</label>
						<input type="radio" name="getsocial_facebook" id="gsfversend" value="box_count_send" <?php if (get_option('getsocial_facebook', "box_count_send") == "box_count_send") { _e('checked="checked"', "getsocial_facebook"); }?> /><label for="gsfversend">Like + Send</label>
						<input type="radio" name="getsocial_facebook" id="gsfhide" value="hide" <?php if (get_option('getsocial_facebook', "box_count_send") == "hide") { _e('checked="checked"', "getsocial_facebook"); }?> /><label for="gsfhide">Hide</label>
					</div></div>
				</li>
			<?php }
			break;
		case 'rgp':
			if ($context == 'display') {
				if (get_option('getsocial_googleplusone') != "hide") {
					$po_style = (get_option('getsocial_googleplusone', 'vertical') == "vertical") ? '':'annotation="none"';
					$html = '<div class="sharebutton">'
							.'<script type="text/javascript" src="http://apis.google.com/js/plusone.js"></script>'
							.'<g:plusone size="tall" ' . $po_style . ' href="'. $permalink  .'"></g:plusone></div>';
				}
			}
			if ($context == 'options') { ?>
				<li class="ui-state-default" id="rgp">
					<div class="sortth">Google +1 Button<span class="gsgb getsocial-help"><img src="<?php echo plugins_url();?>/getsocial/images/help.png"></span></div>
					<div class="sorttd"><div id="radio-gc">
						<input type="radio" name="getsocial_googleplusone" id="gsgver" value="vertical" <?php if (get_option('getsocial_googleplusone', "vertical") == "vertical") { _e('checked="checked"', "getsocial_googleplusone"); }?> /><label for="gsgver">Button + Count</label>
						<input type="radio" name="getsocial_googleplusone" id="gsgnc" value="none" <?php if (get_option('getsocial_googleplusone', "vertical") == "none") { _e('checked="checked"', "getsocial_googleplusone"); }?> /><label for="gsgnc">No Count</label>
						<input type="radio" name="getsocial_googleplusone" id="gsghide" value="hide" <?php if (get_option('getsocial_googleplusone', "vertical") == "hide") { _e('checked="checked"', "getsocial_googleplusone"); }?> /><label for="gsghide">Hide</label>
					</div></div>
				</li>
			<?php }
			break;
		case 'rsu':
			if ($context == 'display') {
				if (get_option('getsocial_stumbleupon') != "hide") {
					$su_style = (get_option('getsocial_stumbleupon', 'hide') == "vertical") ? '5':'6';
					$html = '<div class="sharebutton">'
							.'<su:badge layout="' . $su_style . '"></su:badge>'
							.' <script type="text/javascript">'
							." (function() { "
							."     var li = document.createElement('script'); li.type = 'text/javascript'; li.async = true;"
							."     li.src = window.location.protocol + '//platform.stumbleupon.com/1/widgets.js'; "
							."     var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(li, s);"
							." })();"
							.' </script>'
							.'</div>';
				}
			}
			if ($context == 'options') { ?>
				<li class="ui-state-default" id="rsu">
					<div class="sortth">StumbleUpon Button<span class="gssb getsocial-help"><img src="<?php echo plugins_url();?>/getsocial/images/help.png"></span></div>
					<div class="sorttd"><div id="radio-sc">
						<input type="radio" name="getsocial_stumbleupon" id="gssver" value="vertical" <?php if (get_option('getsocial_stumbleupon', "hide") == "vertical") { _e('checked="checked"', "getsocial_stumbleupon"); }?> /><label for="gssver">Button + Count</label>
						<input type="radio" name="getsocial_stumbleupon" id="gssnc" value="none" <?php if (get_option('getsocial_stumbleupon', "hide") == "none") { _e('checked="checked"', "getsocial_stumbleupon"); }?> /><label for="gssnc">No Count</label>
						<input type="radio" name="getsocial_stumbleupon" id="gsshide" value="hide" <?php if (get_option('getsocial_stumbleupon', "hide") == "hide") { _e('checked="checked"', "getsocial_stumbleupon"); }?> /><label for="gsshide">Hide</label>
					</div></div>
				</li>
			<?php }
			break;
		case 'rdg':
			if ($context == 'display') {
				if (get_option('getsocial_digg', 'hide') != "hide") {
					$html = '<div class="sharebutton">'
							.'<script type="text/javascript">'
							.'(function() {'
							.'var s = document.createElement(\'SCRIPT\'), s1 = document.getElementsByTagName(\'SCRIPT\')[0];'
							.'s.type = \'text/javascript\';'
							.'s.async = true;'
							.'s.src = \'http://widgets.digg.com/buttons.js\';'
							.'s1.parentNode.insertBefore(s, s1);'
							.'})();'
							.'</script>'
							.'<a class="DiggThisButton ' . get_option('getsocial_digg','DiggMedium') . '"></a></div>';
				}
			}
			if ($context == 'options') { ?>
				<li class="ui-state-default" id="rdg">
					<div class="sortth">Digg Button<span class="gsdb getsocial-help"><img src="<?php echo plugins_url();?>/getsocial/images/help.png"></span></div>
					<div class="sorttd"><div id="radio-dc">
						<input type="radio" name="getsocial_digg" id="gsdver" value="DiggMedium" <?php if (get_option('getsocial_digg', "hide") == "DiggMedium") { _e('checked="checked"', "getsocial_digg"); }?> /><label for="gsdver">Button + Count</label>
						<input type="radio" name="getsocial_digg" id="gsdnc" value="DiggIcon" <?php if (get_option('getsocial_digg', "hide") == "DiggIcon") { _e('checked="checked"', "getsocial_digg"); }?> /><label for="gsdnc">No Count</label>
						<input type="radio" name="getsocial_digg" id="gsdhide" value="hide" <?php if (get_option('getsocial_digg', "hide") == "hide") { _e('checked="checked"', "getsocial_digg"); }?> /><label for="gsdhide">Hide</label>
					</div></div>
				</li>
			<?php }
			break;
		case 'rli':
			if ($context == 'display') {
				if (get_option('getsocial_linkedin', 'hide') != "hide") {
					$li_style = (get_option('getsocial_linkedin') == "vertical") ? ' data-counter="top"':'';
					$html = '<div class="sharebutton">'
							.'<script src="http://platform.linkedin.com/in.js" type="text/javascript"></script>'
							.'<script type="IN/Share"'. $li_style .'></script>'
							.'</div>';
				}
			}
			if ($context == 'options') { ?>
				<li class="ui-state-default" id="rli">
					<div class="sortth">LinkedIn Button<span class="gslb getsocial-help"><img src="<?php echo plugins_url();?>/getsocial/images/help.png"></span></div>
					<div class="sorttd"><div id="radio-lc">
						<input type="radio" name="getsocial_linkedin" id="gslver" value="vertical" <?php if (get_option('getsocial_linkedin', "hide") == "vertical") { _e('checked="checked"', "getsocial_linkedin"); }?> /><label for="gslver">Button + Count</label>
						<input type="radio" name="getsocial_linkedin" id="gslnc" value="none" <?php if (get_option('getsocial_linkedin', "hide") == "none") { _e('checked="checked"', "getsocial_linkedin"); }?> /><label for="gslnc">No Count</label>
						<input type="radio" name="getsocial_linkedin" id="gslhide" value="hide" <?php if (get_option('getsocial_linkedin', "hide") == "hide") { _e('checked="checked"', "getsocial_linkedin"); }?> /><label for="gslhide">Hide</label>
					</div></div>
				</li>
			<?php }
			break;
		case 'rpi':
			if ($context == 'display') {
				if (get_option('getsocial_pinterest') != "hide" && !empty($gs_image_url) ) {
					$html = '<div class="sharebutton">'
							.'<a href="http://pinterest.com/pin/create/button/?url='. urlencode($permalink) .'&media=' . urlencode($gs_image_url) . '&description=' . $gs_title .'" class="pin-it-button" count-layout="' . get_option('getsocial_pinterest', 'vertical') . '"><img border="0" src="//assets.pinterest.com/images/PinExt.png" title="Pin It" /></a>'
							.'<script type="text/javascript" src="//assets.pinterest.com/js/pinit.js"></script>'
							.'</div>';
				}
			}
			if ($context == 'options') { ?>
				<li class="ui-state-default" id="rpi">
					<div class="sortth">Pinterest Pin it Button<span class="gspb getsocial-help"><img src="<?php echo plugins_url();?>/getsocial/images/help.png"></span></div>
					<div class="sorttd"><div id="radio-pc">
						<input type="radio" name="getsocial_pinterest" id="gspver" value="vertical" <?php if (get_option('getsocial_pinterest', "hide") == "vertical") { _e('checked="checked"', "getsocial_pinterest"); }?> /><label for="gspver">Button + Count</label>
						<input type="radio" name="getsocial_pinterest" id="gspnc" value="none" <?php if (get_option('getsocial_pinterest', "hide") == "none") { _e('checked="checked"', "getsocial_pinterest"); }?> /><label for="gspnc">No Count</label>
						<input type="radio" name="getsocial_pinterest" id="gsphide" value="hide" <?php if (get_option('getsocial_pinterest', "hide") == "hide") { _e('checked="checked"', "getsocial_pinterest"); }?> /><label for="gsphide">Hide</label>
					</div></div>
				</li>
			<?php }
			break;
		case 'rab':
			if ($context == 'display') {
				$getsocial_additional = get_option('getsocial_additional');
				if ( $getsocial_additional != "") {
					$html = '<div class="sharebutton">' . $getsocial_additional .'</div>';
				}
			}
			if ($context == 'options') { ?>
				<li class="ui-state-default" id="rab">
					<div class="sortth">Additional buttons<span class="ab getsocial-help"><img src="<?php echo plugins_url();?>/getsocial/images/help.png"></span></div>
					<div class="sorttd">
						<textarea name="getsocial_additional" id="getsocial_additional" cols="82" rows="5"><?php echo esc_textarea( get_option('getsocial_additional') ); ?></textarea>
					</div>
				</li>
			<?php }
			break;
		default :
			break;
	}
	return $html;
}

function getsocial_admin_notice() {
	if( 'dismiss' == $_GET['gsmsg'] ) {
		update_option('getsocial_show_remote_massage', 'dismiss');
		wp_cache_delete( 'getsocial_show_remote_massage' );
	}
	if( 'remind' == $_GET['gsmsg'] ) {
		update_option('getsocial_show_remote_massage', time() + ( 7 * 24 * 60 * 60) );
		wp_cache_delete( 'getsocial_show_remote_massage' );
	}
	
	$show_msg = get_option('getsocial_show_remote_massage', 'show');
	
	if ( is_numeric ( $show_msg ) ) {
		$diff = time() - intval( $show_msg );
		if ( $diff > 0 ) $show_msg = "show";
	}

	if ( $show_msg == "show" ) {
		$msg = wp_remote_get( 'http://socialmetricspro.com/api/gsapi.php?context=getsocial' );
		if (!is_wp_error($msg) ) {
			$dismiss_uri = add_query_arg('gsmsg', 'dismiss', $_SERVER['REQUEST_URI'] );
			$remind_uri = add_query_arg('gsmsg', 'remind', $_SERVER['REQUEST_URI'] );
			if ( $msg['response']['code'] == 200 && ( !empty( $msg['body'] ) ) ) {
				echo '<div id="message" class="updated" style="padding:10px;margin-top:10px;">' . $msg['body'] . ' [ <a href="' . $remind_uri . '">Remind me later</a> | <a href="' . $dismiss_uri . '">Dismiss</a> ]</div>';
			}
		}
	}
}
add_action('admin_notices', 'getsocial_admin_notice');
?>