class Header extends HTMLElement {
    constructor() {
        super();
    }

    connectedCallback() {
        this.innerHTML = `
  <style>
    .stickyHeader{
    position: fixed;
    z-index: 2;
}

header {
    background-color: #2cccd3;
    background-image: url(/assets/headerClouds.png);
    background-repeat: no-repeat;
    background-size: cover;
    background-position: center;
    border-bottom: .5rem solid #cbd543;
    justify-content: space-around;
    position: relative;
    width: 100vw;
}

.headerContents{
    width: 90%;
    margin: 0 auto;
}

.logo{
    position: absolute;
    z-index: 1;
}

.logoImg{
    width:20vw;
}

.mainNavContainer{
    align-items: flex-end;
    display: flex;
    justify-content: center;
}

.mainNav{
    display: flex;
    list-style-type: none;
}

.mainNavItem{
    background-color: #cbd543;
    border-top-left-radius: .75rem;
    border-top-right-radius: .75rem;
    margin-left: .75rem;
    padding: .75rem 2rem;
    text-transform: uppercase;
    white-space: nowrap;
}

.mainNavItem a{
    color: #474747;
    text-decoration: none;
}

.mainNavItem a:hover{
    font-weight: 900;
}

/*.mainNavItem a:active {*/
/*    font-weight: 900;*/
/*}*/

/*.mainNavItem a:focus {*/
/*    font-weight: 900;*/
/*}*/

.topNav{
    display: flex;
    justify-content: end;
}

.topNavItem{
    background-color: #cbd543;
    border-bottom-left-radius: .75rem;
    border-bottom-right-radius: .75rem;
    font-size: 1rem;
    margin-left: .75rem;
    padding: .5rem 1rem;
    text-transform: uppercase;
    white-space: nowrap;
}

.topNavItem a{
    color: #474747;
    text-decoration: none;
}

.topNavItem a:hover{
    font-weight: 900;
}

.logoWG{
    transform: translate(-2vw, 1vw);
}

.logoImgWG{
    width:15vw;
}

/*secondary nav*/
.secondaryNavContainer{
    background-color: #cbd543;
    width: 100vw;

}

.secondaryNav{
    display: flex;
    list-style-type: none;
    margin: auto;
    width: 80%;
}
.secondaryNavItem{
    font-size: 1rem;
    padding: 1rem 2rem .75rem;
    text-transform: uppercase;
    white-space: nowrap;
}

.secondaryNavItem a{
    color: #474747;
    text-decoration: none;
}

.secondaryNavItem a:hover{
    border-bottom: solid .125rem;
}

/*.activeSubNav {*/
/*    border-bottom: solid .125rem;*/
/*}*/

/*.secondaryNavItem a:active{*/
/*    border-bottom: solid .125rem;*/
/*}*/

  </style>
  <div class="stickyHeader">
    <header>
        <div class="headerContents">
            <div class="topNav">
                <ul class="mainNav">
                    <li class="topNavItem"><a href="/login">Log In</a></li>
                    <li class="topNavItem"><a href="/sign-up">Sign Up</a></li>
                </ul>
            </div>
            <div class="logo">
                <img src="/assets/ed_logo.png" alt="" class="logoImg">
            </div>

            <div class=""> </div>

            <div class="mainNavContainer">
                <ul class="mainNav">
                    <li sec:authorize="isAuthenticated()" class="mainNavItem"><a href="/teachers">Teachers</a></li>
                    <li class="mainNavItem" style="margin-left: 1rem;"><a href="/welcome">Welcome</a></li>
                    <li class="mainNavItem"><a href="/about-us">About Us</a></li>
                    <li class="mainNavItem"><a href="/our-games">Our Games</a></li>
                    <li class="mainNavItem"><a href="/get-involved">Get Involved</a></li>
                    <li class="mainNavItem"><a href="/donate">Donate</a></li>
                </ul>
                <div class="logoWG">
                    <img src="/assets/weatherhead.PNG" alt="" class="logoImgWG">
                </div>
            </div>
        </div>
            <div class="secondaryNavContainer">
        <ul class="secondaryNav">
            <li class="secondaryNavItem"><a href="/faq">FAQ's</a></li>
            <li class="secondaryNavItem"><a href="/awards">Awards</a></li>
            <li class="secondaryNavItem"><a href="/privacy">Privacy</a></li>
            <li class="secondaryNavItem"><a href="/terms-of-use">Terms of Use</a></li>
            <li class="secondaryNavItem"><a href="/activity-help">Activity Help</a></li>
        </ul>
    </div>
</div>
    </header>
`;
    }
}

customElements.define('header-component', Header);