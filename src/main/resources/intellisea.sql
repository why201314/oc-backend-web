--
-- PostgreSQL database dump
--

-- Dumped from database version 14.10 (Homebrew)
-- Dumped by pg_dump version 14.10 (Homebrew)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: account; Type: TABLE; Schema: public; Owner: midnightforever
--

CREATE TABLE public.account (
    account_id integer NOT NULL,
    name character varying(255),
    address1 character varying(255),
    address2 character varying(255),
    address3 character varying(255),
    phone_number character varying(20),
    homepage character varying(255),
    ipc_type character varying(50)
);


ALTER TABLE public.account OWNER TO midnightforever;

--
-- Name: account_account_id_seq; Type: SEQUENCE; Schema: public; Owner: midnightforever
--

CREATE SEQUENCE public.account_account_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.account_account_id_seq OWNER TO midnightforever;

--
-- Name: account_account_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: midnightforever
--

ALTER SEQUENCE public.account_account_id_seq OWNED BY public.account.account_id;


--
-- Name: admin; Type: TABLE; Schema: public; Owner: midnightforever
--

CREATE TABLE public.admin (
    admin_id integer NOT NULL,
    username character varying(255),
    password character varying(255)
);


ALTER TABLE public.admin OWNER TO midnightforever;

--
-- Name: admin_admin_id_seq; Type: SEQUENCE; Schema: public; Owner: midnightforever
--

CREATE SEQUENCE public.admin_admin_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.admin_admin_id_seq OWNER TO midnightforever;

--
-- Name: admin_admin_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: midnightforever
--

ALTER SEQUENCE public.admin_admin_id_seq OWNED BY public.admin.admin_id;


--
-- Name: contact; Type: TABLE; Schema: public; Owner: midnightforever
--

CREATE TABLE public.contact (
    contact_id integer NOT NULL,
    name character varying(255),
    phone_number character varying(20),
    mail character varying(255),
    duties character varying(255)
);


ALTER TABLE public.contact OWNER TO midnightforever;

--
-- Name: contact_contact_id_seq; Type: SEQUENCE; Schema: public; Owner: midnightforever
--

CREATE SEQUENCE public.contact_contact_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.contact_contact_id_seq OWNER TO midnightforever;

--
-- Name: contact_contact_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: midnightforever
--

ALTER SEQUENCE public.contact_contact_id_seq OWNED BY public.contact.contact_id;


--
-- Name: employee; Type: TABLE; Schema: public; Owner: midnightforever
--

CREATE TABLE public.employee (
    employee_id integer NOT NULL,
    name character varying(255),
    mail character varying(255),
    employee_code integer,
    duty character varying(255)
);


ALTER TABLE public.employee OWNER TO midnightforever;

--
-- Name: employee_employee_id_seq; Type: SEQUENCE; Schema: public; Owner: midnightforever
--

CREATE SEQUENCE public.employee_employee_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.employee_employee_id_seq OWNER TO midnightforever;

--
-- Name: employee_employee_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: midnightforever
--

ALTER SEQUENCE public.employee_employee_id_seq OWNED BY public.employee.employee_id;


--
-- Name: meeting; Type: TABLE; Schema: public; Owner: midnightforever
--

CREATE TABLE public.meeting (
    meeting_id integer NOT NULL,
    meeting_date date,
    contact_id integer,
    content character varying(255),
    status character varying(50),
    employees_id integer[]
);


ALTER TABLE public.meeting OWNER TO midnightforever;

--
-- Name: meeting_meeting_id_seq; Type: SEQUENCE; Schema: public; Owner: midnightforever
--

CREATE SEQUENCE public.meeting_meeting_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.meeting_meeting_id_seq OWNER TO midnightforever;

--
-- Name: meeting_meeting_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: midnightforever
--

ALTER SEQUENCE public.meeting_meeting_id_seq OWNED BY public.meeting.meeting_id;


--
-- Name: monthly_work_info; Type: TABLE; Schema: public; Owner: midnightforever
--

CREATE TABLE public.monthly_work_info (
    monthly_work_info_id integer NOT NULL,
    employee_id integer,
    date date,
    file_path character varying(255),
    note date
);


ALTER TABLE public.monthly_work_info OWNER TO midnightforever;

--
-- Name: monthly_work_info_monthly_work_info_id_seq; Type: SEQUENCE; Schema: public; Owner: midnightforever
--

CREATE SEQUENCE public.monthly_work_info_monthly_work_info_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.monthly_work_info_monthly_work_info_id_seq OWNER TO midnightforever;

--
-- Name: monthly_work_info_monthly_work_info_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: midnightforever
--

ALTER SEQUENCE public.monthly_work_info_monthly_work_info_id_seq OWNED BY public.monthly_work_info.monthly_work_info_id;


--
-- Name: sales; Type: TABLE; Schema: public; Owner: midnightforever
--

CREATE TABLE public.sales (
    sales_id integer NOT NULL,
    company_id integer,
    content character varying(255),
    start_date date,
    status character varying(50),
    end_date date
);


ALTER TABLE public.sales OWNER TO midnightforever;

--
-- Name: sales_sales_id_seq; Type: SEQUENCE; Schema: public; Owner: midnightforever
--

CREATE SEQUENCE public.sales_sales_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sales_sales_id_seq OWNER TO midnightforever;

--
-- Name: sales_sales_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: midnightforever
--

ALTER SEQUENCE public.sales_sales_id_seq OWNED BY public.sales.sales_id;


--
-- Name: work_info; Type: TABLE; Schema: public; Owner: midnightforever
--

CREATE TABLE public.work_info (
    work_info_id integer NOT NULL,
    employee_id integer,
    start_time time without time zone,
    end_time time without time zone,
    append character varying(255),
    note character varying(255)
);


ALTER TABLE public.work_info OWNER TO midnightforever;

--
-- Name: work_info_work_info_id_seq; Type: SEQUENCE; Schema: public; Owner: midnightforever
--

CREATE SEQUENCE public.work_info_work_info_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.work_info_work_info_id_seq OWNER TO midnightforever;

--
-- Name: work_info_work_info_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: midnightforever
--

ALTER SEQUENCE public.work_info_work_info_id_seq OWNED BY public.work_info.work_info_id;


--
-- Name: account account_id; Type: DEFAULT; Schema: public; Owner: midnightforever
--

ALTER TABLE ONLY public.account ALTER COLUMN account_id SET DEFAULT nextval('public.account_account_id_seq'::regclass);


--
-- Name: admin admin_id; Type: DEFAULT; Schema: public; Owner: midnightforever
--

ALTER TABLE ONLY public.admin ALTER COLUMN admin_id SET DEFAULT nextval('public.admin_admin_id_seq'::regclass);


--
-- Name: contact contact_id; Type: DEFAULT; Schema: public; Owner: midnightforever
--

ALTER TABLE ONLY public.contact ALTER COLUMN contact_id SET DEFAULT nextval('public.contact_contact_id_seq'::regclass);


--
-- Name: employee employee_id; Type: DEFAULT; Schema: public; Owner: midnightforever
--

ALTER TABLE ONLY public.employee ALTER COLUMN employee_id SET DEFAULT nextval('public.employee_employee_id_seq'::regclass);


--
-- Name: meeting meeting_id; Type: DEFAULT; Schema: public; Owner: midnightforever
--

ALTER TABLE ONLY public.meeting ALTER COLUMN meeting_id SET DEFAULT nextval('public.meeting_meeting_id_seq'::regclass);


--
-- Name: monthly_work_info monthly_work_info_id; Type: DEFAULT; Schema: public; Owner: midnightforever
--

ALTER TABLE ONLY public.monthly_work_info ALTER COLUMN monthly_work_info_id SET DEFAULT nextval('public.monthly_work_info_monthly_work_info_id_seq'::regclass);


--
-- Name: sales sales_id; Type: DEFAULT; Schema: public; Owner: midnightforever
--

ALTER TABLE ONLY public.sales ALTER COLUMN sales_id SET DEFAULT nextval('public.sales_sales_id_seq'::regclass);


--
-- Name: work_info work_info_id; Type: DEFAULT; Schema: public; Owner: midnightforever
--

ALTER TABLE ONLY public.work_info ALTER COLUMN work_info_id SET DEFAULT nextval('public.work_info_work_info_id_seq'::regclass);


--
-- Data for Name: account; Type: TABLE DATA; Schema: public; Owner: midnightforever
--

COPY public.account (account_id, name, address1, address2, address3, phone_number, homepage, ipc_type) FROM stdin;
\.


--
-- Data for Name: admin; Type: TABLE DATA; Schema: public; Owner: midnightforever
--

COPY public.admin (admin_id, username, password) FROM stdin;
1	Reth	password
\.


--
-- Data for Name: contact; Type: TABLE DATA; Schema: public; Owner: midnightforever
--

COPY public.contact (contact_id, name, phone_number, mail, duties) FROM stdin;
124				0
155	155			0
135	kk			0
\.


--
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: midnightforever
--

COPY public.employee (employee_id, name, mail, employee_code, duty) FROM stdin;
11	1	1	1	1
10	1	1	1	1
13	1	1	1	1
15	1	1	1	1
13213	1321	123	123	132
\.


--
-- Data for Name: meeting; Type: TABLE DATA; Schema: public; Owner: midnightforever
--

COPY public.meeting (meeting_id, meeting_date, contact_id, content, status, employees_id) FROM stdin;
\.


--
-- Data for Name: monthly_work_info; Type: TABLE DATA; Schema: public; Owner: midnightforever
--

COPY public.monthly_work_info (monthly_work_info_id, employee_id, date, file_path, note) FROM stdin;
\.


--
-- Data for Name: sales; Type: TABLE DATA; Schema: public; Owner: midnightforever
--

COPY public.sales (sales_id, company_id, content, start_date, status, end_date) FROM stdin;
\.


--
-- Data for Name: work_info; Type: TABLE DATA; Schema: public; Owner: midnightforever
--

COPY public.work_info (work_info_id, employee_id, start_time, end_time, append, note) FROM stdin;
\.


--
-- Name: account_account_id_seq; Type: SEQUENCE SET; Schema: public; Owner: midnightforever
--

SELECT pg_catalog.setval('public.account_account_id_seq', 1, false);


--
-- Name: admin_admin_id_seq; Type: SEQUENCE SET; Schema: public; Owner: midnightforever
--

SELECT pg_catalog.setval('public.admin_admin_id_seq', 1, true);


--
-- Name: contact_contact_id_seq; Type: SEQUENCE SET; Schema: public; Owner: midnightforever
--

SELECT pg_catalog.setval('public.contact_contact_id_seq', 1, false);


--
-- Name: employee_employee_id_seq; Type: SEQUENCE SET; Schema: public; Owner: midnightforever
--

SELECT pg_catalog.setval('public.employee_employee_id_seq', 1, false);


--
-- Name: meeting_meeting_id_seq; Type: SEQUENCE SET; Schema: public; Owner: midnightforever
--

SELECT pg_catalog.setval('public.meeting_meeting_id_seq', 1, false);


--
-- Name: monthly_work_info_monthly_work_info_id_seq; Type: SEQUENCE SET; Schema: public; Owner: midnightforever
--

SELECT pg_catalog.setval('public.monthly_work_info_monthly_work_info_id_seq', 1, false);


--
-- Name: sales_sales_id_seq; Type: SEQUENCE SET; Schema: public; Owner: midnightforever
--

SELECT pg_catalog.setval('public.sales_sales_id_seq', 1, false);


--
-- Name: work_info_work_info_id_seq; Type: SEQUENCE SET; Schema: public; Owner: midnightforever
--

SELECT pg_catalog.setval('public.work_info_work_info_id_seq', 1, false);


--
-- Name: account account_pkey; Type: CONSTRAINT; Schema: public; Owner: midnightforever
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_pkey PRIMARY KEY (account_id);


--
-- Name: admin admin_pkey; Type: CONSTRAINT; Schema: public; Owner: midnightforever
--

ALTER TABLE ONLY public.admin
    ADD CONSTRAINT admin_pkey PRIMARY KEY (admin_id);


--
-- Name: contact contact_pkey; Type: CONSTRAINT; Schema: public; Owner: midnightforever
--

ALTER TABLE ONLY public.contact
    ADD CONSTRAINT contact_pkey PRIMARY KEY (contact_id);


--
-- Name: employee employee_pkey; Type: CONSTRAINT; Schema: public; Owner: midnightforever
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (employee_id);


--
-- Name: meeting meeting_pkey; Type: CONSTRAINT; Schema: public; Owner: midnightforever
--

ALTER TABLE ONLY public.meeting
    ADD CONSTRAINT meeting_pkey PRIMARY KEY (meeting_id);


--
-- Name: monthly_work_info monthly_work_info_pkey; Type: CONSTRAINT; Schema: public; Owner: midnightforever
--

ALTER TABLE ONLY public.monthly_work_info
    ADD CONSTRAINT monthly_work_info_pkey PRIMARY KEY (monthly_work_info_id);


--
-- Name: sales sales_pkey; Type: CONSTRAINT; Schema: public; Owner: midnightforever
--

ALTER TABLE ONLY public.sales
    ADD CONSTRAINT sales_pkey PRIMARY KEY (sales_id);


--
-- Name: work_info work_info_pkey; Type: CONSTRAINT; Schema: public; Owner: midnightforever
--

ALTER TABLE ONLY public.work_info
    ADD CONSTRAINT work_info_pkey PRIMARY KEY (work_info_id);


--
-- PostgreSQL database dump complete
--

